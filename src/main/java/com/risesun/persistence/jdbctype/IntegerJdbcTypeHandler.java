package com.risesun.persistence.jdbctype;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IntegerJdbcTypeHandler extends AbstractJdbcTypeHandler<Integer> {

    @Override
    protected void setNullParameter(PreparedStatement preparedStatement, int parameterIndex, JdbcType jdbcType) throws SQLException {
        preparedStatement.setNull(parameterIndex, JdbcType.INTEGER.TYPE_CODE);
    }

    @Override
    protected void setNotNullParameter(PreparedStatement preparedStatement, int parameterIndex, Integer parameterValue) throws SQLException {
        preparedStatement.setInt(parameterIndex, parameterValue);
    }

    @Override
    protected Integer getNullableValue(ResultSet resultSet, String columnName) throws SQLException {
        return resultSet.getInt(columnName);
    }

    @Override
    protected Integer getNullableValue(ResultSet resultSet, int columnIndex) throws SQLException {
        return resultSet.getInt(columnIndex);
    }
}
