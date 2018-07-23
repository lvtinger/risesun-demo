package com.risesun.persistence.statment;

import com.risesun.persistence.datasource.Datasource;
import com.risesun.persistence.jdbctype.JdbcType;
import com.risesun.persistence.jdbctype.JdbcTypeHandler;
import com.risesun.persistence.mapper.CommandType;
import com.risesun.persistence.metadata.PropertyHandler;
import com.risesun.persistence.parameter.ParameterMapper;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PreparedStatementHandler implements StatementHandler {
    @Override
    public Statement statement(Datasource datasource, StatementMapper statementMapper, Object... args) throws Exception {
        Connection connection = datasource.getConnection();

        PreparedStatement statement = statementMapper.getCommandType().equals(CommandType.INSERT_AUTO_KEY)
                ? connection.prepareStatement(statementMapper.getCommandText(), Statement.RETURN_GENERATED_KEYS)
                : connection.prepareStatement(statementMapper.getCommandText());

        parameterHandler(statement, statementMapper.getParameters(), args);

        return statement;
    }

    private void parameterHandler(PreparedStatement statement, List<ParameterMapper> parameters, Object[] args) throws SQLException, InvocationTargetException, IllegalAccessException {
        if (parameters != null && parameters.size() > 0) {
            int length = parameters.size();
            for (int i = 0; i < length; i++) {
                ParameterMapper parameter = parameters.get(i);
                int parameterIndex = i + 1;
                Object parameterValue = args[parameter.getArgumentsIndex()];
                if (parameter.getPropertyHandler() == null) {
                    parameterHandler(statement, parameterIndex, parameterValue, parameter.getJdbcTypeHandler(), parameter.getJdbcType());
                } else {
                    PropertyHandler propertyHandler = parameter.getPropertyHandler();
                    parameterValue = propertyHandler.getGetterInvoker().invoke(parameterValue);
                    parameterHandler(statement, parameterIndex, parameterValue, propertyHandler.getJdbcTypeHandler(), propertyHandler.getJdbcType());
                }
            }
        }
    }

    private void parameterHandler(PreparedStatement statement, int parameterIndex, Object parameterValue, JdbcTypeHandler<?> jdbcTypeHandler, JdbcType jdbcType) throws SQLException {
        jdbcTypeHandler.set(statement, parameterIndex, parameterValue, jdbcType);
    }

    @Override
    public int update(Statement statement, StatementMapper statementMapper) throws SQLException {
        PreparedStatement preparedStatement = (PreparedStatement) statement;
        return preparedStatement.executeUpdate();
    }
}