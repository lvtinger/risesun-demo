package com.risesun.persistence.parser;

import java.util.List;

public abstract class Parser {


    protected List<Node> nodes;

    public Parser(List<Node> nodes) {
        this.nodes = nodes;
    }

    public static Parser build(List<Node> nodes) {
        if (nodes == null || nodes.size() == 0) {
            throw new NullPointerException("nodes is null or empty");
        }

        Node node = nodes.get(0);
        Token token = node.getToken();
        switch (token) {
            case SELECT:
                break;
            case INSERT:
                break;
            case UPDATE:
                break;
            case DELETE:
                break;
            default:
                throw new ParserException();
        }
        return null;
    }

    public abstract Parser parse();

    public static class CreateParser extends Parser {

        public CreateParser(List<Node> nodes) {
            super(nodes);
        }

        @Override
        public Parser parse() {
            return null;
        }
    }

    public static class UpdateParser extends Parser {

        public UpdateParser(List<Node> nodes) {
            super(nodes);
        }

        @Override
        public Parser parse() {
            return null;
        }
    }

    public static class DeleteParser extends Parser {

        public DeleteParser(List<Node> nodes) {
            super(nodes);
        }

        @Override
        public Parser parse() {
            return null;
        }
    }

    public static class SelectParser extends Parser {

        public SelectParser(List<Node> nodes) {
            super(nodes);
        }

        @Override
        public Parser parse() {
            return null;
        }
    }
}
