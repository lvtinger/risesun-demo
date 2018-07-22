package com.risesun.common.lang;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReflectionUtils {

    private final static Field[] NO_FIELDS = new Field[0];
    private final static Map<Class, Field[]> FIELD_CACHED = new ConcurrentHashMap<>();

    public static Field[] getFields(final Class clazz) {
        if (clazz == null || clazz.isInterface() || clazz.isEnum() || clazz.isAnnotation()) {
            return NO_FIELDS;
        }

        Field[] fields = FIELD_CACHED.get(clazz);

        if (fields == null) {
            List<Field> list = new LinkedList<>();
            Class<?> current = clazz;
            while (!current.equals(Object.class)){
                fields = current.getDeclaredFields();
                if(fields != null && fields.length > 0){
                    list.addAll(Arrays.asList(fields));
                }
                current = current.getSuperclass();
            }

            fields = list.size() > 0 ? list.toArray(fields) : NO_FIELDS;
            FIELD_CACHED.put(clazz, fields);
        }

        return fields;
    }

}
