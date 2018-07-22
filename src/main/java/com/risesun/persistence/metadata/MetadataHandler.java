package com.risesun.persistence.metadata;

import java.util.Map;

public class MetadataHandler {
    private Class<?> clazz;
    private Map<String, PropertyHandler> properties;

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Map<String, PropertyHandler> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, PropertyHandler> properties) {
        this.properties = properties;
    }
}