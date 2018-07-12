package com.risesun.demo;

public class DefaultConnectionSession implements ConnectionSession {
    private Configuration configuration;

    public DefaultConnectionSession(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return this.configuration;
    }
}
