package com.risesun.demo;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapperProxyFactory<T> {
    private final Class<T> type;
    private final Map<Method, MapperMethod> cache;

    public MapperProxyFactory(Class<T> type) {
        this.type = type;
        this.cache = new ConcurrentHashMap<Method, MapperMethod>();
    }

    public Class<T> getType() {
        return type;
    }

    public Map<Method, MapperMethod> getCache() {
        return cache;
    }

    protected T newInstance(MapperProxy<T> proxy) {
        return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, proxy);
    }

    public T newInstance(ConnectionSession session) {
        MapperProxy<T> proxy = new MapperProxy<T>(session, type, cache);
        return newInstance(proxy);
    }
}
