package com.risesun.persistence.parser;

/**
 * SQL语句中的常用关键字
 * <br>
 * 1、SELECT * FROM TABLE WHERE COLUMN = ${COLUMN} AND COLUMN = ${COLUMN} ORDER BY COLUMN LIMIT 0, 1
 * <br>
 * 2、INSERT TABLE(COLUMN) VALUES(${COLUMN})
 * <br>
 * 3、UPDATE TABLE SET COLUMN = ${COLUMN} WHERE COLUMN = ${COLUMN} OR COLUMN = ${COLUMN}
 * <br>
 * 4、DELETE FROM TABLE WHERE COLUMN = ${COLUMN}
 *
 * @author qiuxu
 */
public enum Token {
    SELECT("select"),
    AS("as"),
    FROM("from"),
    WHERE("where"),
    ORDER("order"),
    BY("by"),
    DESC("desc"),
    ASC("asc"),
    LIMIT("limit"),
    INSERT("insert"),
    INTO("into"),
    VALUES("values"),
    UPDATE("update"),
    SET("set"),
    DELETE("delete"),
    AND("and"),
    OR("or"),
    LIKE("like"),


    EQ("="),
    LT("<"),
    LTE("<="),
    GT(">"),
    GTE(">="),
    NEQ("!="),
    STAR("*"),

    COMMA(","),
    DOT("."),
    DOLLAR("$"),
    LPAREN("("),
    RPAREN(")"),
    LBRACE("}"),
    RBRACE("}"),

    PARAMETER("${}"),
    IDENTIFIER("#{identifier}"),
    DIGIT("#{digit}"),
    STRING("#{string}");

    public final String value;

    Token(String value) {
        this.value = value;
    }
}
