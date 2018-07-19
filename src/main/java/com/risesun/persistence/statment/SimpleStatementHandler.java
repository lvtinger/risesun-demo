package com.risesun.persistence.statment;

import com.risesun.persistence.StatementMapper;
import com.risesun.persistence.datasource.Datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleStatementHandler implements StatementHandler {

    @Override
    public Statement statement(Datasource datasource, StatementMapper statementMapper) throws Exception {
        Statement statement = datasource.getConnection().createStatement();
        return statement;
    }

    @Override
    public Statement prepareStatement(Connection connection, StatementMapper statementMapper) throws SQLException {
        Statement statement = connection.createStatement();
        return statement;
    }
}
