package com.risesun.persistence.invoker;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class FieldSetterInvoker implements SetterInvoker {
    private final Field field;

    public FieldSetterInvoker(Field field) {
        this.field = field;
    }

    @Override
    public void invoke(Object target, Object value) throws IllegalAccessException, InvocationTargetException {
        field.set(target, value);
    }
}
