package com.risesun.persistence.statment;

import com.risesun.persistence.mapper.StatementMapper;
import com.risesun.persistence.datasource.Datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleStatementHandler implements StatementHandler {
    @Override
    public Statement statement(Datasource datasource, StatementMapper statementMapper, Object... args) throws Exception {
        Connection connection = datasource.getConnection();
        Statement statement = connection.createStatement();
        return statement;
    }

    @Override
    public int update(Statement statement, StatementMapper statementMapper) throws SQLException {
        return statement.executeUpdate(statementMapper.getCommand());
    }
}