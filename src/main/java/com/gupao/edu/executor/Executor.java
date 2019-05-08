package com.gupao.edu.executor;

/**
 * 用来执行sql
 */
public interface Executor {
    <T> T query(String sql, Object[] parameter, Class object);
}
