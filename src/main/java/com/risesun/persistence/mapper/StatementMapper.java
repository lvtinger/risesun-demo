package com.risesun.persistence.mapper;

import com.risesun.persistence.statment.DynamicStatementBuilder;

import java.util.List;

/**
 * @author qiuxu
 */
public class StatementMapper {
    private String command;
    private List<ParameterMapper> parameters;
    private DynamicStatementBuilder builder;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public List<ParameterMapper> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParameterMapper> parameters) {
        this.parameters = parameters;
    }

    public DynamicStatementBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(DynamicStatementBuilder builder) {
        this.builder = builder;
    }
}