package com.risesun.persistence.jdbctype;

import java.util.LinkedHashMap;
import java.util.Map;

public class JdbcTypeHolder {
    private final Map<Class<?>, JdbcTypeHandler<?>> holder = new LinkedHashMap<>();

    public <T> void put(Class<T> clazz, JdbcTypeHandler<T> typeHandler){
        holder.put(clazz, typeHandler);
    }

    public <T> JdbcTypeHandler<T> get(Class<T> clazz){
        return (JdbcTypeHandler<T>) holder.get(clazz);
    }

    public static class Builder {
        private static final JdbcTypeHolder TYPE_HOLDER;
        static  {
            TYPE_HOLDER = new JdbcTypeHolder();
            TYPE_HOLDER.put(Integer.class, new IntegerJdbcTypeHandler());
            TYPE_HOLDER.put(String.class, new StringJdbcTypeHandler());
        }

        public static JdbcTypeHolder get(){
            return TYPE_HOLDER;
        }
    }
}
