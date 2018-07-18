package com.risesun.persistence.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author qiuxu
 */
public abstract class AbstractTypeHandler<T> implements TypeHandler<T> {

    @Override
    public void set(PreparedStatement preparedStatement, int parameterIndex, T parameterValue, JdbcType jdbcType) throws SQLException {
        if(parameterValue == null){
            setNullParameter(preparedStatement, parameterIndex, jdbcType);
        } else {
            setNotNullParameter(preparedStatement, parameterIndex, parameterValue);
        }
    }

    /**
     * 设置空参数
     * @param preparedStatement
     * @param parameterIndex
     * @param jdbcType
     * @throws SQLException
     */
    protected abstract void setNullParameter(PreparedStatement preparedStatement, int parameterIndex, JdbcType jdbcType) throws SQLException;

    /**
     * 设置非空参数
     * @param preparedStatement
     * @param parameterIndex
     * @param parameterValue
     * @throws SQLException
     */
    protected abstract void setNotNullParameter(PreparedStatement preparedStatement, int parameterIndex, T parameterValue) throws SQLException;


    @Override
    public T get(ResultSet resultSet, String columnName) throws SQLException {
        T value = getNullableValue(resultSet, columnName);
        return resultSet.wasNull() ? null :value;
    }

    /**
     * 读取值
     * @param resultSet
     * @param columnName
     * @return
     */
    protected abstract T getNullableValue(ResultSet resultSet, String columnName) throws SQLException;

    @Override
    public T get(ResultSet resultSet, int columnIndex) throws SQLException {
        T value = getNullableValue(resultSet, columnIndex);
        return resultSet.wasNull() ? null : value;
    }

    /**
     * 读取值
     * @param resultSet
     * @param columnIndex
     * @return
     */
    protected abstract T getNullableValue(ResultSet resultSet, int columnIndex) throws SQLException;
}
