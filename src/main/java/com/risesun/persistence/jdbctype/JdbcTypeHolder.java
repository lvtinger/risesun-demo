package com.risesun.persistence.jdbctype;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author qiuxu
 */
public final class JdbcTypeHolder {
    private final Map<Class<?>, JdbcTypeHandler<?>> mapper = new ConcurrentHashMap<>();

    public <T> void put(Class<T> clazz, JdbcTypeHandler<T> handler){
        mapper.put(clazz, handler);
    }

    public JdbcTypeHandler<?> get(Class<?> clazz){
        return mapper.get(clazz);
    }

    private JdbcTypeHolder(){
    }

    public static <T> void putJdbcHandler(Class<T> clazz, JdbcTypeHandler<T> handler) {
        Builder.TYPE_HOLDER.put(clazz, handler);
    }

    public static JdbcTypeHandler<?> getJdbcTypeHandler(Class<?> clazz) {
        return Builder.TYPE_HOLDER.get(clazz);
    }

    public static class Builder {
        private static final JdbcTypeHolder TYPE_HOLDER;

        static {
            TYPE_HOLDER = new JdbcTypeHolder();
            TYPE_HOLDER.mapper.put(Integer.class, new IntegerJdbcTypeHandler());
            TYPE_HOLDER.mapper.put(String.class, new StringJdbcTypeHandler());
        }
    }
}
