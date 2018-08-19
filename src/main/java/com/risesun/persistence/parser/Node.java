package com.risesun.persistence.parser;

/**
 * @author qiuxu
 */
public final class Node {
    private Token token;
    private String text;

    public static NodeBuilder build() {
        return new NodeBuilder();
    }

    public Token getToken() {
        return token;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Node{" +
                "token=" + token +
                ", text='" + text + '\'' +
                '}';
    }

    public static class NodeBuilder {
        private Node node = new Node();

        private NodeBuilder() {

        }

        public NodeBuilder token(Token token) {
            node.token = token;
            return this;
        }

        public NodeBuilder text(String text) {
            node.text = text;
            return this;
        }

        public Node get() {
            if (this.node.getText() == null) {
                this.node.text = this.node.token.value.toUpperCase();
            }
            return this.node;
        }
    }
}