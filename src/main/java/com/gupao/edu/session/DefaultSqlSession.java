package com.gupao.edu.session;


/**
 * 默认会话类
 */
public class DefaultSqlSession {
    private Configuration configuration;
    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    public <T> T getMapper(Class<T> clazz) {
        return configuration.getMapper(clazz,this);
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
