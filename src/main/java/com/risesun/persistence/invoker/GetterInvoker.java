package com.risesun.persistence.invoker;

import java.lang.reflect.InvocationTargetException;

/**
 * @author qiuxu
 */
public interface GetterInvoker {
    Object invoke(Object source) throws IllegalAccessException, InvocationTargetException;
}
