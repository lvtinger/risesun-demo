package com.risesun.persistence.test;

import com.risesun.persistence.parser.CharTypes;
import com.risesun.persistence.parser.Lexer;
import org.junit.Test;

public class TestLexer {
    @Test
    public void testBase() {
        parse("SELECT userId, username, password FROM user WHERE userId = ${userId}");

        parse("INSERT INTO user (userId, username, password) VALUES (${userId}, ${username}, ${password})");

        parse("UPDATE user SET username = ${username}, password = ${password} WHERE userId = ${userId}");

        parse("DELETE FROM user WHERE userId = ${userId}");
    }

    @Test
    public void testSelect(){
        parse("SELECT userId, username, password FROM user WHERE username = ${username} AND (password=${password} OR code=${code})");
    }

    private void parse(String text){
        Lexer lexer = new Lexer(text);
        while (lexer.getChar() != CharTypes.EOI) {
            lexer.nextToken();
            System.out.println(lexer.getNode());
        }
        System.out.println("==================================================================");
    }
}