package com.risesun.persistence.mapper;

import com.risesun.persistence.jdbctype.JdbcTypeHandler;
import com.risesun.persistence.metadata.PropertyHandler;

/**
 * @author qiuxu
 */
public class ParameterMapper {
    private int parameterIndex;
    private PropertyHandler propertyHandler;
    private JdbcTypeHandler<?> jdbcTypeHandler;

    public int getParameterIndex() {
        return parameterIndex;
    }

    public void setParameterIndex(int parameterIndex) {
        this.parameterIndex = parameterIndex;
    }

    public PropertyHandler getPropertyHandler() {
        return propertyHandler;
    }

    public void setPropertyHandler(PropertyHandler propertyHandler) {
        this.propertyHandler = propertyHandler;
    }

    public JdbcTypeHandler<?> getJdbcTypeHandler() {
        return jdbcTypeHandler;
    }

    public void setJdbcTypeHandler(JdbcTypeHandler<?> jdbcTypeHandler) {
        this.jdbcTypeHandler = jdbcTypeHandler;
    }
}