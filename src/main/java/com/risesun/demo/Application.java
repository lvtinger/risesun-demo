package com.risesun.demo;

public class Application {
    public static void main(String... args){
        Configuration configuration = new DefaultConfiguration();
        ConnectionSession session = new DefaultConnectionSession(configuration);
        MapperProxyFactory<UserAPI> factory = new MapperProxyFactory<UserAPI>(UserAPI.class);
        UserAPI api = factory.newInstance(session);
        System.out.println(api.getUserName());
    }
}
