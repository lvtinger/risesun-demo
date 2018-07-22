package com.risesun.persistence.metadata;

import com.risesun.exception.RisesunException;
import com.risesun.persistence.invoker.GetterInvoker;
import com.risesun.persistence.invoker.MethodGetterInvkoer;
import com.risesun.persistence.invoker.MethodSetterInvoker;
import com.risesun.persistence.invoker.SetterInvoker;
import com.risesun.persistence.jdbctype.JdbcTypeHandler;
import com.risesun.persistence.jdbctype.JdbcTypeHandlerHolder;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class MetadataHandlerHolder {
    private final Map<Class, MetadataHandler> handlers = new ConcurrentHashMap<>();

    public static MetadataHandler getMetadataHandler(Class clazz) {
        return Builder.HOLDER.get(clazz);
    }

    public static void putMetadataHandler(Class clazz, MetadataHandler metadataHandler) {
        Builder.HOLDER.put(clazz, metadataHandler);
    }

    public void put(Class clazz, MetadataHandler handler) {
        handlers.put(clazz, handler);
    }

    public MetadataHandler get(Class clazz) {
        return handlers.get(clazz);
    }

    public static class Builder {
        private static final MetadataHandlerHolder HOLDER = new MetadataHandlerHolder();

        public static MetadataHandler build(Class clazz) {

            MetadataHandler handler = HOLDER.get(clazz);
            if (handler != null) {
                return handler;
            }

            try {
                handler = generate(clazz);
            } catch (NoSuchMethodException e) {
                throw new RisesunException();
            }

            HOLDER.put(clazz, handler);

            return handler;
        }

        private static MetadataHandler generate(Class clazz) throws NoSuchMethodException {
            Class current = clazz;
            Map<String, PropertyHandler> properties = new LinkedHashMap<>();

            while (current != Object.class) {
                Field[] fields = current.getFields();
                for (Field field : fields) {
                    int modifiers = field.getModifiers();
                    if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers)) {
                        continue;
                    }
                    String getterName =
                            field.getType().equals(Boolean.class)
                                    ? "is" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1)
                                    : "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                    Method getter = current.getDeclaredMethod(getterName, null);
                    String setterName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                    Method setter = current.getDeclaredMethod(setterName, field.getType());


                    GetterInvoker getterInvoker = new MethodGetterInvkoer(getter);
                    SetterInvoker setterInvoker = new MethodSetterInvoker(setter);
                    JdbcTypeHandler<?> jdbcTypeHandler = JdbcTypeHandlerHolder.getJdbcTypeHandler(field.getType());

                    PropertyHandler propertyHandler = new PropertyHandler();
                    propertyHandler.setPropertyName(field.getName());
                    propertyHandler.setPropertyType(field.getType());
                    propertyHandler.setGetterInvoker(getterInvoker);
                    propertyHandler.setSetterInvoker(setterInvoker);
                    propertyHandler.setJdbcTypeHandler(jdbcTypeHandler);

                    properties.put(field.getName(), propertyHandler);
                }

                current = clazz.getSuperclass();
            }

            MetadataHandler handler = new MetadataHandler();
            handler.setClazz(clazz);
            handler.setProperties(properties);

            return handler;
        }
    }
}
