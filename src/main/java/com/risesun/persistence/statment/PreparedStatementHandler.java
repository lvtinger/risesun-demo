package com.risesun.persistence.statment;

import com.risesun.persistence.StatementMapper;
import com.risesun.persistence.datasource.Datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatementHandler implements StatementHandler {
    @Override
    public Statement statement(Datasource datasource, StatementMapper statementMapper) throws Exception {
        PreparedStatement statement = datasource.getConnection()
                .prepareStatement(statementMapper.getCommand());
        return statement;
    }

    @Override
    public Statement prepareStatement(Connection connection, StatementMapper statementMapper) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(statementMapper.getCommand());
        return statement;
    }
}