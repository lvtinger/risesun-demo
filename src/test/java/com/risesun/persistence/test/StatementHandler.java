package com.risesun.persistence.test;

import com.risesun.persistence.datasource.Datasource;
import com.risesun.persistence.datasource.DefaultDatasource;
import com.risesun.persistence.jdbctype.JdbcType;
import com.risesun.persistence.jdbctype.JdbcTypeHandlerHolder;
import com.risesun.persistence.mapper.CommandType;
import com.risesun.persistence.mapper.ParameterMapper;
import com.risesun.persistence.mapper.StatementMapper;
import com.risesun.persistence.statment.PreparedStatementHandler;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class StatementHandler {

    private Datasource getDatasource() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/persistence";
        String username = "risesun";
        String password = "123456";
        Datasource datasource = new DefaultDatasource(driver, url, username, password);

        return datasource;
    }

    private StatementMapper getInsertStatementMapper() throws NoSuchFieldException {
        List<ParameterMapper> parameters = new LinkedList<>();
        //parameters.add(getProfileIdParameter());
        parameters.add(getNicknameParameter());

        StatementMapper mapper = new StatementMapper();
        mapper.setCommandText("INSERT INTO profile(nickname) VALUES(?)");
        mapper.setParameters(parameters);
        mapper.setCommandType(CommandType.INSERT_AUTO_KEY);
        return mapper;
    }

    private ParameterMapper getProfileIdParameter() throws NoSuchFieldException {
        Field profileId = Profile.class.getDeclaredField("profileId");
        int modifiers = profileId.getModifiers();
        if (Modifier.isPrivate(modifiers)) {
            profileId.setAccessible(true);
        }

        ParameterMapper profileParameter = new ParameterMapper();
        profileParameter.setField(profileId);
        profileParameter.setJdbcType(JdbcType.INTEGER);
        profileParameter.setTypeHandler(JdbcTypeHandlerHolder.getJdbcTypeHandler(Integer.class));
        profileParameter.setParameterIndex(0);

        return profileParameter;
    }

    private ParameterMapper getNicknameParameter() throws NoSuchFieldException {

        Field nickname = Profile.class.getDeclaredField("nickname");
        int modifiers = nickname.getModifiers();
        if (Modifier.isPrivate(modifiers)) {
            nickname.setAccessible(true);
        }

        ParameterMapper nicknameParameter = new ParameterMapper();
        nicknameParameter.setParameterIndex(0);
        nicknameParameter.setTypeHandler(JdbcTypeHandlerHolder.getJdbcTypeHandler(String.class));
        nicknameParameter.setJdbcType(JdbcType.STRING);
        nicknameParameter.setField(nickname);

        return nicknameParameter;
    }

    @Test
    public void testStatement() throws Exception {
        Datasource datasource = getDatasource();

        Profile profile = new Profile();
        profile.setNickname("risesun");
        //profile.setProfileId(1);

        StatementMapper statementMapper = getInsertStatementMapper();

        PreparedStatementHandler handler = new PreparedStatementHandler();
        Statement statement = handler.statement(datasource, statementMapper, profile);
        int update = handler.update(statement, statementMapper);
        System.out.println(update);
        System.out.println(profile);
    }
}
