package com.risesun.persistence.statment;

import com.risesun.persistence.StatementMapper;
import com.risesun.persistence.datasource.Datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface StatementHandler {
    Statement statement(Datasource datasource, StatementMapper statementMapper) throws Exception;
    Statement prepareStatement(Connection connection, StatementMapper statementMapper) throws SQLException;
}
