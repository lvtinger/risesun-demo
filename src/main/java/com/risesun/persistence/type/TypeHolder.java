package com.risesun.persistence.type;

import java.util.LinkedHashMap;
import java.util.Map;

public class TypeHolder {
    private final Map<Class<?>, TypeHandler<?>> holder = new LinkedHashMap<>();

    public <T> void put(Class<T> clazz, TypeHandler<T> typeHandler){
        holder.put(clazz, typeHandler);
    }

    public <T> TypeHandler<T> get(Class<T> clazz){
        return (TypeHandler<T>) holder.get(clazz);
    }

    public static class Builder {
        private static final TypeHolder TYPE_HOLDER;
        static  {
            TYPE_HOLDER = new TypeHolder();
            TYPE_HOLDER.put(Integer.class, new IntegerTypeHandler());
            TYPE_HOLDER.put(String.class, new StringTypeHandler());
        }

        public static TypeHolder get(){
            return TYPE_HOLDER;
        }
    }
}
