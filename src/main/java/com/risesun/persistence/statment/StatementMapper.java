package com.risesun.persistence.statment;

import com.risesun.persistence.mapper.CommandType;
import com.risesun.persistence.parameter.ParameterMapper;

import java.util.List;

/**
 * @author qiuxu
 */
public class StatementMapper {
    private String commandText;
    private CommandType commandType;
    private List<ParameterMapper> parameters;
    private DynamicStatementBuilder builder;

    public String getCommandText() {
        return commandText;
    }

    public void setCommandText(String commandText) {
        this.commandText = commandText;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
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