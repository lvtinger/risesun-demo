package com.risesun.persistence.parameter;

import java.sql.PreparedStatement;
import java.util.List;

public class DefaultParameterHandler implements ParameterHandler {

    @Override
    public void execute(PreparedStatement preparedStatement, List<ParameterMapper> mappers, Object... args) {

    }
}