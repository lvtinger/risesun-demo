package com.risesun.persistence.result;

import java.sql.ResultSet;

public interface ResultMapping<T> {
    <T> T convert(ResultSet resultSet);
}