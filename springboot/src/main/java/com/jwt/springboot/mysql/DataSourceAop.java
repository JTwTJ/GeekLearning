package com.jwt.springboot.mysql;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author jiangwentao
 * @date 2021/4/19
 * @detail aop实现SpringBoot下的数据源动态切换
 */
@Aspect
@Component
@Slf4j
public class DataSourceAop {

    @Pointcut(value = "execution(* com.jwt.springboot.mapper..*.*(..))")
    public void point() {
    }

    @Before("point()")
    public void before(JoinPoint joinPoint) {
        log.info("ready to set dynamic datasource");
        Class<?> target = joinPoint.getTarget().getClass();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        for (Class<?> anInterface : target.getInterfaces()) {
            resolveDataSource(anInterface, signature.getMethod());
        }
        resolveDataSource(target, signature.getMethod());
    }

    /**
     * 提取目标对象方法注解和类型注解中的数据源标识
     *
     * @param clazz
     * @param method
     */
    private void resolveDataSource(Class<?> clazz, Method method) {
        try {
            Class<?>[] types = method.getParameterTypes();
            // 默认使用类型注解-也就是使用定义类上面的注解
            if (clazz.isAnnotationPresent(DataSource.class)) {
                DataSource source = clazz.getAnnotation(DataSource.class);
                DataSourceType.setDataSourceType(source.value());
            }
            // 方法注解可以覆盖类型注解-也就是使用方法上的注解去替换类上面的注解
            Method m = clazz.getMethod(method.getName(), types);
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource source = m.getAnnotation(DataSource.class);
                DataSourceType.setDataSourceType(source.value());
            }
        } catch (Exception e) {
            System.out.println(clazz + ":" + e.getMessage());
        }
    }

    @After("point()")
    public void removeDataSource() {
        log.info("ready to remove dataSource");
        DataSourceType.removeDataSourceType();
    }
}
