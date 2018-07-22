package com.risesun.persistence.mapper;

import com.risesun.persistence.metadata.PropertyHandler;

public class ResultSetMapper {
    private int columnIndex;
    private PropertyHandler propertyHandler;

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public PropertyHandler getPropertyHandler() {
        return propertyHandler;
    }

    public void setPropertyHandler(PropertyHandler propertyHandler) {
        this.propertyHandler = propertyHandler;
    }
}
