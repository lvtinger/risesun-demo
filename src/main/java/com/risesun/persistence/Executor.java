package com.risesun.persistence;

import com.risesun.persistence.datasource.Datasource;
import com.risesun.persistence.mapper.StatementMapper;

public interface Executor {
    int update(Datasource datasource, StatementMapper mapper, Object[] args) throws Exception;
}