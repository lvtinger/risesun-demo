package com.risesun.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatementHandler implements StatementHandler {
    @Override
    public Statement prepareStatement(Connection connection, StatementMapper statementMapper) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(statementMapper.getCommand());
        return statement;
    }
}