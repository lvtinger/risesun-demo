package com.risesun.demo;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class MapperProxy<T> implements InvocationHandler, Serializable {
    private static final long serialVersionUID = 6994499970899940103L;

    private ConnectionSession session;
    private Class<T> type;
    private Map<Method, MapperMethod> cache;

    public MapperProxy(ConnectionSession session, Class<T> type, Map<Method, MapperMethod> cache) {
        this.session = session;
        this.type = type;
        this.cache = cache;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        MapperMethod mapperMethod = cache.get(method);
        if(mapperMethod == null){
            mapperMethod = new MapperMethod(type, method, session.getConfiguration());
            cache.put(method, mapperMethod);
        }

        return mapperMethod.execute(session, args);
    }
}
