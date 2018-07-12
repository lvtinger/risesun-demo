package com.risesun.demo;

public class DefaultInterceptor implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        return invocation.proceed();
    }
}
