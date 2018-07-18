package com.risesun.persistence;

import java.sql.PreparedStatement;

public class DefaultExecutor implements Executor {
    @Override
    public int update(Datasource datasource, StatementMapper mapper, Object[] args) throws Exception {
        PreparedStatement statement = datasource.getConnection()
                .prepareStatement(mapper.getCommand());



        int count = statement.executeUpdate();
        return count;
    }
}
