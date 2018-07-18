package com.risesun.persistence.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface TypeHandler<T> {
    /**
     * 设置PreparedStatement参数值
     * @param preparedStatement
     * @param parameterIndex
     * @param parameterValue
     * @param jdbcType
     */
    void set(PreparedStatement preparedStatement, int parameterIndex, T parameterValue, JdbcType jdbcType) throws SQLException;

    /**
     * 读取ResultSet的值
     * @param resultSet
     * @param columnName
     * @return
     */
    T get(ResultSet resultSet, String columnName) throws SQLException;

    /**
     * 读取ResultSet的值
     * @param resultSet
     * @param columnIndex
     * @return
     */
    T get(ResultSet resultSet, int columnIndex) throws SQLException;
}
