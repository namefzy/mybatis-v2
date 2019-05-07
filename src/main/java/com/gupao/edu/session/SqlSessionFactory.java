package com.gupao.edu.session;


/**
 *
 * 会话工厂类；实例化Configuration产生SqlSession
 */
public class SqlSessionFactory {
    private Configuration configuration;
    public SqlSessionFactory build() {
        configuration = new Configuration();
        return this;
    }


    public DefaultSqlSession openSqlSession() {
        return new DefaultSqlSession(configuration);
    }
}
