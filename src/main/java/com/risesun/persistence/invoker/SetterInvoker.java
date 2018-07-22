package com.risesun.persistence.invoker;

import java.lang.reflect.InvocationTargetException;

public interface SetterInvoker {
    void invoke(Object target, Object value) throws IllegalAccessException, InvocationTargetException;
}
