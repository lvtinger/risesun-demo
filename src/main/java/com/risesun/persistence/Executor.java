package com.risesun.persistence;

import com.risesun.persistence.datasource.Datasource;

public interface Executor {
    int update(Datasource datasource, StatementMapper mapper, Object[] args) throws Exception;
}