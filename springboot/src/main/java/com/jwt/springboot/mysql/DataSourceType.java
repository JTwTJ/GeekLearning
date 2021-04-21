package com.jwt.springboot.mysql;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jiangwentao
 * @date 2021/4/19
 * @detail 数据源类型
 */
@Slf4j
public class DataSourceType {

    public enum SourceType {
        /**
         * 极客学习数据源
         */
        GeekLearning(),
        /**
         * 学习demo据源
         */
        Study_Demo,;
    }

    /**
     * 使用ThreadLocal保证线程安全
     */
    private static final ThreadLocal<SourceType> TYPES = new ThreadLocal<>();

    /**
     * 往当前线程里设置数据源类型
     * @param dataSourceType 数据源类型
     */
    public static void setDataSourceType(SourceType dataSourceType) {
        if (dataSourceType == null) {
            throw new NullPointerException();
        }
        TYPES.set(dataSourceType);
    }

    /**
     * 获取数据源类型
     */
    public static SourceType getDataSourceType() {
        SourceType dataSourceType = TYPES.get() == null ? SourceType.GeekLearning : TYPES.get();
        log.warn("当前数据源类型为:" + dataSourceType);
        return dataSourceType;
    }

    /**
     * 清空数据类型
     */
    public static  void removeDataSourceType() {
        TYPES.remove();
    }
}
