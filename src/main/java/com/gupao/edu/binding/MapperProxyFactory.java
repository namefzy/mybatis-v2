package com.gupao.edu.binding;

import com.gupao.edu.session.DefaultSqlSession;

import java.lang.reflect.Proxy;

/**
 * 用于产生代理类MapperProxy
 */
public class MapperProxyFactory<T> {
    private Class<T> mapperInterface;
    private Class object;

    public MapperProxyFactory(Class<T> mapperInterface, Class object) {
        this.mapperInterface = mapperInterface;
        this.object = object;
    }


    public <T> T newInstance(DefaultSqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] { mapperInterface }, new MapperProxy(sqlSession, object));
    }
}
