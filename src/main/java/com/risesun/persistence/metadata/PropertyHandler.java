package com.risesun.persistence.metadata;

import com.risesun.persistence.invoker.GetterInvoker;
import com.risesun.persistence.invoker.SetterInvoker;
import com.risesun.persistence.jdbctype.JdbcTypeHandler;

/**
 * @author qiuxu
 */
public class PropertyHandler {
    private String propertyName;
    private GetterInvoker getterInvoker;
    private SetterInvoker setterInvoker;
    private JdbcTypeHandler<?> jdbcTypeHandler;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public GetterInvoker getGetterInvoker() {
        return getterInvoker;
    }

    public void setGetterInvoker(GetterInvoker getterInvoker) {
        this.getterInvoker = getterInvoker;
    }

    public SetterInvoker getSetterInvoker() {
        return setterInvoker;
    }

    public void setSetterInvoker(SetterInvoker setterInvoker) {
        this.setterInvoker = setterInvoker;
    }

    public JdbcTypeHandler<?> getJdbcTypeHandler() {
        return jdbcTypeHandler;
    }

    public void setJdbcTypeHandler(JdbcTypeHandler<?> jdbcTypeHandler) {
        this.jdbcTypeHandler = jdbcTypeHandler;
    }
}