package com.risesun.persistence.datasource;

import java.sql.Connection;

public interface Datasource {
    Connection getConnection() throws ClassNotFoundException, Exception;
}
