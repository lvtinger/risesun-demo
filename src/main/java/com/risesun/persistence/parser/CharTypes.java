package com.risesun.persistence.parser;

public class CharTypes {
    public final static char EOI = 0X1A;
    private final static boolean[] WHITE_SPACE = new boolean[256];
    private final static boolean[] FIRST_IDENTIFIER = new boolean[256];
    private final static boolean[] IDENTIFIER = new boolean[256];
    private final static boolean[] DIGIT = new boolean[256];

    static {
        for (int i = 0; i < 256; i++) {
            if (i <= 32) {
                WHITE_SPACE[i] = true;
            } else if ('0' <= i && i <= '9') {
                IDENTIFIER[i] = true;
                DIGIT[i] = true;
            } else if ('a' <= i && i <= 'z') {
                FIRST_IDENTIFIER[i] = true;
                IDENTIFIER[i] = true;
            } else if ('A' <= i && i <= 'Z') {
                FIRST_IDENTIFIER[i] = true;
                IDENTIFIER[i] = true;
            } else if (i >= 127) {
                WHITE_SPACE[i] = true;
            }
        }

        //特殊处理
        IDENTIFIER['_'] = true;

    }

    public static boolean isWhitespace(char c) {
        return c < 256 && WHITE_SPACE[c];
    }

    public static boolean isFirstIdentifier(char c) {
        return c < 256 && FIRST_IDENTIFIER[c];
    }

    public static boolean isDigit(char c) {
        return c < 256 && DIGIT[c];
    }

    public static boolean isIdentifier(char c) {
        return c < 256 && IDENTIFIER[c];
    }

    public static boolean isEOI(char c) {
        return EOI == c;
    }
}