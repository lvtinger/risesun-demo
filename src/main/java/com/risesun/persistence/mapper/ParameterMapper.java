package com.risesun.persistence.mapper;

import com.risesun.persistence.jdbctype.JdbcType;
import com.risesun.persistence.jdbctype.JdbcTypeHandler;
import com.risesun.persistence.metadata.PropertyHandler;

import java.lang.reflect.Field;

public class ParameterMapper {
    private JdbcTypeHandler<?> typeHandler;
    private Field field;
    private JdbcType jdbcType;
    private PropertyHandler propertyMapper;
    private int parameterIndex;

    public JdbcTypeHandler<?> getTypeHandler() {
        return typeHandler;
    }

    public void setTypeHandler(JdbcTypeHandler<?> typeHandler) {
        this.typeHandler = typeHandler;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public JdbcType getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(JdbcType jdbcType) {
        this.jdbcType = jdbcType;
    }

    public int getParameterIndex() {
        return parameterIndex;
    }

    public void setParameterIndex(int parameterIndex) {
        this.parameterIndex = parameterIndex;
    }
}
