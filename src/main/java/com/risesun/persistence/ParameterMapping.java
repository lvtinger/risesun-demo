package com.risesun.persistence;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;

public interface ParameterMapping {
    int getIndex();
    Field getField();
}
