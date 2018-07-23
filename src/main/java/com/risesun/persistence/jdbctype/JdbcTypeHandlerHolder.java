package com.risesun.persistence.jdbctype;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author qiuxu
 */
public final class JdbcTypeHandlerHolder {
    private final Map<Class<?>, JdbcTypeHandler<?>> mapper = new ConcurrentHashMap<>();

    private JdbcTypeHandlerHolder() {
    }

    public static <T> void putJdbcHandler(Class<T> clazz, JdbcTypeHandler<T> handler) {
        Builder.TYPE_HOLDER.put(clazz, handler);
    }

    public static JdbcTypeHandler<?> getJdbcTypeHandler(Class<?> clazz) {
        return Builder.TYPE_HOLDER.get(clazz);
    }

    public <T> void put(Class<T> clazz, JdbcTypeHandler<T> handler) {
        mapper.put(clazz, handler);
    }

    public JdbcTypeHandler<?> get(Class<?> clazz) {
        return mapper.get(clazz);
    }

    private static class Builder {
        private static final JdbcTypeHandlerHolder TYPE_HOLDER;

        static {
            TYPE_HOLDER = new JdbcTypeHandlerHolder();
            TYPE_HOLDER.mapper.put(Integer.class, new IntegerJdbcTypeHandler());
            TYPE_HOLDER.mapper.put(String.class, new StringJdbcTypeHandler());
        }
    }
}
