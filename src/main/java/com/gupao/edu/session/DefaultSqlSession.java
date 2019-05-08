package com.gupao.edu.session;


import com.gupao.edu.executor.Executor;

/**
 * 默认会话类
 */
public class DefaultSqlSession {
    private Configuration configuration;
    private Executor executor;
    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    public <T> T getMapper(Class<T> clazz) {
        return configuration.getMapper(clazz,this);
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * 执行查询方法
     * @param statement
     * @param parameter
     * @param object
     * @return
     */
    public <T> T selectOne(String statement, Object[] parameter, Class object) {
        String sql = getConfiguration().getMappedStatement(statement);
        return executor.query(sql,parameter,object);
    }
}
