package com.risesun.persistence.invoker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodSetterInvoker implements SetterInvoker {

    private final Method method;

    public MethodSetterInvoker(Method method) {
        this.method = method;
    }

    @Override
    public void invoke(Object target, Object value) throws IllegalAccessException, InvocationTargetException {
        method.invoke(target, value);
    }
}
