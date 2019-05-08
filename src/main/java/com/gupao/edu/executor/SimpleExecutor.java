package com.gupao.edu.executor;

/**
 * 默认执行的Executor
 */
public class SimpleExecutor implements Executor{
    @Override
    public <T> T query(String sql, Object[] parameter, Class object) {
        return null;
    }
}
