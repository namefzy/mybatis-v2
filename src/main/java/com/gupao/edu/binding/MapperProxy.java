package com.gupao.edu.binding;

import com.gupao.edu.session.DefaultSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 真正的代理类
 */
public class MapperProxy implements InvocationHandler {
    private DefaultSqlSession sqlSession;
    private Class object;

    public MapperProxy(DefaultSqlSession sqlSession, Class object) {
        this.sqlSession = sqlSession;
        this.object = object;
    }


    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String mapperInterface = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String statementId = mapperInterface+"."+methodName;

        //如果根据接口类型+方法名能找到映射的SQL,则执行SQL
        if(sqlSession.getConfiguration().hasStatement(statementId)){
            return sqlSession.selectOne(statementId,args,object);
        }
        //否则直接执行被代理对象的原方法
        return method.invoke(proxy,args);
    }
}
