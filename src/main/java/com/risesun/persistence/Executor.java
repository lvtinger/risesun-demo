package com.risesun.persistence;

import com.risesun.persistence.datasource.Datasource;
import com.risesun.persistence.statment.StatementMapper;

public interface Executor {
    int update(Datasource datasource, StatementMapper mapper, Object[] args) throws Exception;
}