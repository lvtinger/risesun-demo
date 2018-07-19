package com.risesun.persistence.mapper;

import com.risesun.persistence.jdbctype.JdbcType;
import com.risesun.persistence.jdbctype.JdbcTypeHandler;

import java.lang.reflect.Field;

public class ParameterMapper {
    private JdbcTypeHandler<?> typeHandler;
    private Field field;
    private JdbcType jdbcType;

    public JdbcTypeHandler<?> getTypeHandler() {
        return typeHandler;
    }

    public Field getField() {
        return field;
    }

    public JdbcType getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(JdbcType jdbcType) {
        this.jdbcType = jdbcType;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public void setTypeHandler(JdbcTypeHandler<?> typeHandler) {
        this.typeHandler = typeHandler;
    }
}
