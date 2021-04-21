package com.jwt.springboot.mysql;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jiangwentao
 * @date 2021/4/20
 * @detail
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    DataSourceType.SourceType value() default DataSourceType.SourceType.GeekLearning;
}
