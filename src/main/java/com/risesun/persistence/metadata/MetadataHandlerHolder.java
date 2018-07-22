package com.risesun.persistence.metadata;

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

    private static class Builder {
        private static final MetadataHandlerHolder HOLDER = new MetadataHandlerHolder();
    }
}
