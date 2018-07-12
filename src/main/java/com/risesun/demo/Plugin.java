package com.risesun.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

public class Plugin implements InvocationHandler {

    private final Object target;
    private final Interceptor interceptor;
    private final Map<Class<?>, Set<Method>> mapper;

    private Plugin(Object target, Interceptor interceptor, Map<Class<?>, Set<Method>> mapper) {
        this.target = target;
        this.interceptor = interceptor;
        this.mapper = mapper;
    }

    public static Object wrap(Object target, Interceptor interceptor){
        return null;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
