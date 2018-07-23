package com.risesun.persistence.parameter;

import com.risesun.persistence.jdbctype.JdbcType;
import com.risesun.persistence.jdbctype.JdbcTypeHandler;
import com.risesun.persistence.metadata.PropertyHandler;

/**
 * @author qiuxu
 */
public class ParameterMapper {
    private int argumentsIndex;
    private PropertyHandler propertyHandler;
    private JdbcTypeHandler<?> jdbcTypeHandler;
    private JdbcType jdbcType;

    public int getArgumentsIndex() {
        return argumentsIndex;
    }

    public void setArgumentsIndex(int argumentsIndex) {
        this.argumentsIndex = argumentsIndex;
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

    public JdbcType getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(JdbcType jdbcType) {
        this.jdbcType = jdbcType;
    }
}