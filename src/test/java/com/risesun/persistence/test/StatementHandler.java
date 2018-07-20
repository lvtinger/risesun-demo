package com.risesun.persistence.test;

import com.risesun.persistence.datasource.Datasource;
import com.risesun.persistence.datasource.DefaultDatasource;
import com.risesun.persistence.jdbctype.IntegerJdbcTypeHandler;
import com.risesun.persistence.jdbctype.JdbcType;
import com.risesun.persistence.jdbctype.StringJdbcTypeHandler;
import com.risesun.persistence.mapper.ParameterMapper;
import com.risesun.persistence.mapper.StatementMapper;
import com.risesun.persistence.statment.PreparedStatementHandler;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class StatementHandler {

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/persistence?useSSL=false";
    String username = "risesun";
    String password = "123456";

    @Test
    public void testStatement() throws Exception {

        Field profileIdField = Profile.class.getDeclaredField("profileId");
        profileIdField.setAccessible(true);
        Field nicknameField = Profile.class.getDeclaredField("nickname");
        nicknameField.setAccessible(true);

        Datasource datasource = new DefaultDatasource(driver, url, username, password);
        StatementMapper mapper = new StatementMapper();
        mapper.setCommand("INSERT INTO profile(profileId, nickname) VALUES(?, ?)");

        List<ParameterMapper> parameters = new LinkedList<>();
        ParameterMapper profileIdParameter = new ParameterMapper();
        profileIdParameter.setField(profileIdField);
        profileIdParameter.setJdbcType(JdbcType.INTEGER);
        profileIdParameter.setTypeHandler(new IntegerJdbcTypeHandler());
        profileIdParameter.setParameterIndex(0);
        parameters.add(profileIdParameter);

        ParameterMapper nicknameParameter = new ParameterMapper();
        nicknameParameter.setField(nicknameField);
        nicknameParameter.setJdbcType(JdbcType.STRING);
        nicknameParameter.setTypeHandler(new StringJdbcTypeHandler());
        profileIdParameter.setParameterIndex(0);
        parameters.add(nicknameParameter);

        mapper.setParameters(parameters);

        Profile profile = new Profile();
        profile.setProfileId(1);
        profile.setNickname("risesun");

        PreparedStatementHandler statementHandler = new PreparedStatementHandler();
        Statement statement = statementHandler.statement(datasource, mapper, profile);
        int update = statementHandler.update(statement, mapper);
        System.out.println(update);

    }
}
