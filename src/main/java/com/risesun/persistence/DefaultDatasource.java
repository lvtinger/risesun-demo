package com.risesun.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class DefaultDatasource implements Datasource {

    private Connection connection;

    @Override
    public Connection getConnection() throws Exception {
        if(connection == null){
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3006/persistence", "root", "root");
        }
        return connection;
    }
}