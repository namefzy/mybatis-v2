package com.gupao.edu.session;

import com.gupao.edu.binding.MapperRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 保存配置信息
 */
public class Configuration {
    public static final Map<String, String> mappedStatements = new HashMap<String, String>(); // 维护接口方法与SQL关系

    public static final MapperRegistry MAPPER_REGISTRY = new MapperRegistry(); // 维护接口与工厂类关系
    /**
     * 获得代理类
     * @param
     * @param
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> type, DefaultSqlSession sqlSession) {

        return MAPPER_REGISTRY.getMapper(type,sqlSession);
    }

    /**
     * 根据方法名找sql
     * @param statementName
     * @return
     */
    public boolean hasStatement(String statementName) {
        return mappedStatements.containsKey(statementName);
    }
}
