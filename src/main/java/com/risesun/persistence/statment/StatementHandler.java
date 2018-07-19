package com.risesun.persistence.statment;

import com.risesun.persistence.mapper.StatementMapper;
import com.risesun.persistence.datasource.Datasource;

import java.sql.SQLException;
import java.sql.Statement;

public interface StatementHandler {
    Statement statement(Datasource datasource, StatementMapper statementMapper, Object... args) throws Exception;

    int update(Statement statement, StatementMapper statementMapper) throws SQLException;
}
