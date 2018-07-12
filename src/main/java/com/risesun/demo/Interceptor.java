package com.risesun.demo;

public interface Interceptor {
    Object intercept(Invocation invocation) throws Throwable;
}
