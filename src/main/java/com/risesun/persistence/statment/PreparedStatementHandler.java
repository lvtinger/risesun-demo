package com.risesun.persistence.statment;

import com.risesun.persistence.datasource.Datasource;
import com.risesun.persistence.mapper.ParameterMapper;
import com.risesun.persistence.mapper.StatementMapper;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PreparedStatementHandler implements StatementHandler {
    @Override
    public Statement statement(Datasource datasource, StatementMapper statementMapper, Object... args) throws Exception {
        Connection connection = datasource.getConnection();
        PreparedStatement statement = connection.prepareStatement(statementMapper.getCommand());
        List<ParameterMapper> parameters = statementMapper.getParameters();
        if(parameters != null && parameters.size() > 0){
            int length = parameters.size();
            for (int i = 0; i < length; i++){
                ParameterMapper parameter = parameters.get(i);
                Field field = parameter.getField();
                Object value = args[parameter.getParameterIndex()];
                if(field == null){
                    parameter.getTypeHandler().set(statement, i + 1, value, parameter.getJdbcType());
                } else {
                    parameter.getTypeHandler().set(statement, i + 1, parameter.getField().get(value), parameter.getJdbcType());
                }
            }
        }
        return statement;
    }

    @Override
    public int update(Statement statement, StatementMapper statementMapper) throws SQLException {
        PreparedStatement preparedStatement = (PreparedStatement) statement;
        return preparedStatement.executeUpdate();
    }
}