package com.risesun.persistence.parser;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 标识符映射类
 *
 * @author qiuxu
 */
public class Keywords {
    private final static Map<String, Token> tokenMap = new LinkedHashMap<>();

    static {
        tokenMap.put("select", Token.SELECT);
        tokenMap.put("as", Token.AS);
        tokenMap.put("from", Token.FROM);
        tokenMap.put("where", Token.WHERE);
        tokenMap.put("order", Token.ORDER);
        tokenMap.put("by", Token.BY);
        tokenMap.put("desc", Token.DESC);
        tokenMap.put("asc", Token.ASC);
        tokenMap.put("limit", Token.LIMIT);
        tokenMap.put("insert", Token.INSERT);
        tokenMap.put("into", Token.INTO);
        tokenMap.put("values", Token.VALUES);
        tokenMap.put("update", Token.UPDATE);
        tokenMap.put("set", Token.SET);
        tokenMap.put("delete", Token.DELETE);
        tokenMap.put("and", Token.AND);
        tokenMap.put("or", Token.OR);
        tokenMap.put("like", Token.LIKE);
        tokenMap.put("=", Token.EQ);
        tokenMap.put("<", Token.LT);
        tokenMap.put("<=", Token.LTE);
        tokenMap.put(">", Token.GT);
        tokenMap.put(">=", Token.GTE);
        tokenMap.put("!=", Token.NEQ);
        tokenMap.put("*", Token.STAR);
        tokenMap.put(",", Token.COMMA);
        tokenMap.put(".", Token.DOT);
        tokenMap.put("$", Token.DOLLAR);
        tokenMap.put(")", Token.RPAREN);
        tokenMap.put("(", Token.LPAREN);
        tokenMap.put("{", Token.LBRACE);
        tokenMap.put("}", Token.RBRACE);


    }

    /**
     * 根据字符获取标识符
     *
     * @param text 字符
     * @return 标识符枚举
     */
    public static Token get(String text) {
        if (text == null || text.length() == 0) {
            return null;
        }

        return tokenMap.get(text.toLowerCase());
    }
}
