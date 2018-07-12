package com.risesun.demo;

import java.lang.reflect.Method;

public class MapperMethod {
    private Class<?> type;
    private Method method;
    private Configuration configuration;

    public MapperMethod(Class<?> type, Method method, Configuration configuration) {
        this.type = type;
        this.method = method;
        this.configuration = configuration;
    }

    public Object execute(ConnectionSession session, Object[] args) {
        return "execute:" + type.getName() + "." + method.getName();
    }
}