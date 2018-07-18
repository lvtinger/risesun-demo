package com.risesun.persistence;

public interface Executor {
    int update(Datasource datasource, StatementMapper mapper, Object[] args) throws Exception;
}