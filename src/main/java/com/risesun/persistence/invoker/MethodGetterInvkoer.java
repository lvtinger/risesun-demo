package com.risesun.persistence.invoker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodGetterInvkoer implements GetterInvoker {
    private final Method method;

    public MethodGetterInvkoer(Method method) {
        this.method = method;
    }

    @Override
    public Object invoke(Object source) throws IllegalAccessException, InvocationTargetException {
        return method.invoke(source, null);
    }
}
