package com.risesun.persistence.datasource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DefaultDatasource implements Datasource {

    private String driver;
    private String url;
    private String username;
    private String password;

    private Connection connection;

    public DefaultDatasource(String driver, String url, String username, String password) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public Connection getConnection() throws Exception {
        if (connection == null) {
            Class.forName(this.driver);
            connection = DriverManager.getConnection(this.url, this.username, this.password);
        }
        return connection;
    }
}