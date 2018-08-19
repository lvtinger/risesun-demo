package com.risesun.persistence.parser;

public class Lexer {
    private final String text;
    private int position;
    private char ch;
    private int bufferIndex;
    private int bufferLength;
    private String bufferText;
    private Node node;

    public Lexer(String text) {
        this.text = text;
        ch = text.charAt(0);
    }

    public char getChar() {
        return ch;
    }

    public Node getNode() {
        return this.node;
    }

    public void nextToken() {
        for (; ; ) {
            if (CharTypes.isWhitespace(ch)) {
                ch = charAt(++position);
                continue;
            }

            if (ch == '$') {
                scanVariable();
                break;
            }

            if (CharTypes.isFirstIdentifier(ch)) {
                scanIdentifier();
                break;
            }

            if (CharTypes.isDigit(ch)) {
                scanDigit();
                break;
            }

            if (ch == '\'') {
                scanValue();
                break;
            }

            switch (ch) {
                case '>':
                case '<':
                    char c = charAt(++position);
                    if (c == '=') {
                        String str = String.valueOf(ch) + String.valueOf(c);
                        this.node = Node.build().token(Keywords.get(str)).get();
                        this.ch = charAt(++position);
                        return;
                    } else {
                        this.node = Node.build().token(Keywords.get(String.valueOf(ch))).get();
                        return;
                    }
                case '*':
                case '(':
                case ')':
                case ',':
                case '=':
                    this.node = Node.build().token(Keywords.get(String.valueOf(ch))).get();
                    this.ch = charAt(++position);
                    return;
                case '!':
                    if (charAt(++position) != '=') {
                        throw new ParserException();
                    }
                    this.node = Node.build().token(Token.NEQ).get();
                    this.ch = charAt(++position);
                    return;
            }

            if (this.ch == CharTypes.EOI) {

                return;
            }
        }
    }

    /**
     * 扫描变量
     */
    private void scanVariable() {
        if (ch != '$') {
            throw new ParserException();
        }

        char c = charAt(position + 1);
        if (c != '{') {
            throw new ParserException();
        }

        bufferIndex = position;
        bufferLength = 2;
        for (; ; ) {
            scanChar();
            if (ch == '}') {
                break;
            }
            bufferLength++;
        }


        this.ch = charAt(++position);

        bufferText = text.substring(bufferIndex + 2, bufferIndex + bufferLength - 1);
        this.node = Node.build().token(Token.PARAMETER).text(bufferText).get();
    }

    /**
     * 扫描标识
     */
    private void scanIdentifier() {
        this.bufferIndex = position;
        bufferLength = 1;

        for (; ; ) {
            ch = charAt(++position);
            if (!CharTypes.isIdentifier(ch)) {
                break;
            }

            bufferLength++;
        }

        this.ch = charAt(position);

        if (this.bufferLength == 1) {
            this.node = Node.build().token(Token.IDENTIFIER).text(String.valueOf(this.ch)).get();
            return;
        }

        bufferText = text.substring(bufferIndex, bufferIndex + bufferLength);

        Token token = Keywords.get(bufferText);
        if (token != null) {
            this.node = Node.build().token(token).get();
            return;
        } else {
            this.node = Node.build().token(Token.IDENTIFIER).text(bufferText).get();
            return;
        }

    }

    /**
     * 扫描数字
     */
    private void scanDigit() {
        this.bufferIndex = position;
        bufferLength = 1;
        for (; ; ) {
            ch = charAt(++position);
            if (!CharTypes.isDigit(ch) && ch != '.') {
                break;
            }
            bufferLength++;
        }

        this.ch = charAt(position);
        bufferText = text.substring(bufferIndex, bufferIndex + bufferLength);

        this.node = Node.build().token(Token.DIGIT).text(this.bufferText).get();
    }

    /**
     * 扫描常量
     */
    private void scanValue() {
        this.bufferIndex = position;
        bufferLength = 1;
        for (; ; ) {
            ch = charAt(++position);
            if (ch == '\'' && charAt(position - 1) != '\\') {
                break;
            }
            bufferLength++;
        }

        this.ch = charAt(++position);
        bufferText = text.substring(bufferIndex, bufferIndex + bufferLength);

        this.node = Node.build().token(Token.STRING).text(this.bufferText).get();
    }

    private void scanChar() {
        ch = charAt(++position);
    }

    private char charAt(int index) {
        if (index >= this.text.length()) {
            return CharTypes.EOI;
        }

        return this.text.charAt(index);
    }
}
