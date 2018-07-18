package com.risesun.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface TypeHandler<T> {
    void set(PreparedStatement statement, int index, T value, JdbcType type);
    T get(ResultSet resultSet, int index);
}