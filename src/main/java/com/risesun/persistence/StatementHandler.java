package com.risesun.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface StatementHandler {
    Statement prepareStatement(Connection connection, StatementMapper statementMapper) throws SQLException;
}
