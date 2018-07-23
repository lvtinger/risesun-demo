package com.risesun.persistence.statment;

import com.risesun.persistence.datasource.Datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DynamicStatementHandler implements StatementHandler {
    @Override
    public Statement statement(Datasource datasource, StatementMapper statementMapper, Object... args) throws Exception {
        Connection connection = datasource.getConnection();
        DynamicStatementBuilder builder = statementMapper.getBuilder();

        return null;
    }

    @Override
    public int update(Statement statement, StatementMapper statementMapper) throws SQLException {
        return 0;
    }
}