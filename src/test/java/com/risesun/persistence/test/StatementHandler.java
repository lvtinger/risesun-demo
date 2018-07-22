package com.risesun.persistence.test;

import com.risesun.persistence.datasource.Datasource;
import com.risesun.persistence.datasource.DefaultDatasource;

public class StatementHandler {

    private Datasource getDatasource() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/persistence";
        String username = "risesun";
        String password = "123456";
        Datasource datasource = new DefaultDatasource(driver, url, username, password);

        return datasource;
    }
}
