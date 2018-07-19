package com.risesun.persistence.jdbctype;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StringJdbcTypeHandler extends AbstractJdbcTypeHandler<String> {
    @Override
    protected void setNullParameter(PreparedStatement preparedStatement, int parameterIndex, JdbcType jdbcType) throws SQLException {
        preparedStatement.setNull(parameterIndex, JdbcType.STRING.TYPE_CODE);
    }

    @Override
    protected void setNotNullParameter(PreparedStatement preparedStatement, int parameterIndex, String parameterValue) throws SQLException {
        preparedStatement.setString(parameterIndex, parameterValue);
    }

    @Override
    protected String getNullableValue(ResultSet resultSet, String columnName) throws SQLException {
        return resultSet.getString(columnName);
    }

    @Override
    protected String getNullableValue(ResultSet resultSet, int columnIndex) throws SQLException {
        return resultSet.getString(columnIndex);
    }
}
