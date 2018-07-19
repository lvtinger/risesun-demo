package com.risesun.persistence.metadata;

import java.lang.reflect.Field;

public interface JavaTypeHandler<T> {
    void setValue(Object target, Field field, T value) throws IllegalAccessException;
    T getValue(Object target, Field field) throws IllegalAccessException;
}
