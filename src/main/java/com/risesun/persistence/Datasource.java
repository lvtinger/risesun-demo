package com.risesun.persistence;

import java.sql.Connection;

public interface Datasource {
    Connection getConnection() throws ClassNotFoundException, Exception;
}
