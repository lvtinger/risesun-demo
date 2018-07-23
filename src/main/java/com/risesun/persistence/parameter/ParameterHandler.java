package com.risesun.persistence.parameter;

import java.sql.PreparedStatement;
import java.util.List;

public interface ParameterHandler {
    void execute(PreparedStatement preparedStatement, List<ParameterMapper> mappers, Object... args);
}
