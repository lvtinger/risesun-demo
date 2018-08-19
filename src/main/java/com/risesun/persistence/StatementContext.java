package com.risesun.persistence;

/**
 * @author qiuxu
 */
public class StatementContext {
    private final StatementWrapper wrapper;

    private Object result;

    public StatementContext(StatementWrapper wrapper) {
        this.wrapper = wrapper;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
