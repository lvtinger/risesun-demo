package com.risesun.persistence;

import java.sql.PreparedStatement;

public interface ParameterHandler {
    void parameter(PreparedStatement statement, Object[] objects);
}
