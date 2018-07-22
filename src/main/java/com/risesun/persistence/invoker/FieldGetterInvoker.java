package com.risesun.persistence.invoker;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class FieldGetterInvoker implements GetterInvoker {

    private final Field field;

    public FieldGetterInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object source) throws IllegalAccessException, InvocationTargetException {
        return field.get(source);
    }
}
