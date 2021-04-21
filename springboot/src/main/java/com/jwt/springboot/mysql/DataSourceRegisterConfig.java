package com.jwt.springboot.mysql;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.util.ObjectUtils;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangwentao
 * @date 2021/4/19
 * @detail 数据源配置类
 */
@Configuration
@EnableConfigurationProperties(MybatisPlusProperties.class)
public class DataSourceRegisterConfig {

    @Autowired
    private MybatisPlusProperties mybatisPlusProperties;

    /**
     * 主数据源
     */
    @Primary
    @ConfigurationProperties("spring.datasource.ds1")
    @Bean(name = "ds1DataSource")
    public DataSource ds1DataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * ds2数据源
     */
    @Bean(name = "ds2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.ds2")
    public DataSource ds2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicDataSource")
    public DynamicDataSource dynamicDataSource() {
        Map<Object, Object> targetDataSource = new HashMap<>(2);
        targetDataSource.put(DataSourceType.SourceType.GeekLearning, ds1DataSource());
        targetDataSource.put(DataSourceType.SourceType.Study_Demo, ds2DataSource());
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(targetDataSource);
        dynamicDataSource.setDefaultTargetDataSource(ds2DataSource());
        return dynamicDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }

    @Bean
    @ConfigurationProperties(prefix = "mybatis")
    public MybatisSqlSessionFactoryBean sqlSessionFactoryBean() {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        /**
         * 这里在applications.properties里面配置了
         * mybatis-plus.type-aliases-package=com.jwt.springboot.dao
         * mybatis-plus.mapper-locations=classpath:mapper/*Mapper.xml
         * 但多数据源情况下执行sql总会报：org.apache.ibatis.binding.BindingException:
         * Invalid bound statement (not found)........
         * 原因是 this.mapperLocations 为null
         *
         * 注！！！！这里有大坑， 因为这里是自定义的sqlSessionFactoryBean，所以导致
         * 没有启动时没有通过org.mybatis.spring.boot.autoconfigure.MybatisPlusAutoConfiguration
         * 类的sqlSessionFactory(DataSource dataSource)方法自动装配sqlSessionFactoryBean
         * 自定义的sqlSessionFactoryBean所以也没设置mapperLocations
         * 故自定义实例化sqlSessionFactoryBean这里需要手动设置mapperLocations
         * 可参考：https://developer.aliyun.com/article/754124
         */
        if (!ObjectUtils.isEmpty(this.mybatisPlusProperties.resolveMapperLocations())) {
            sqlSessionFactoryBean.setMapperLocations(this.mybatisPlusProperties.resolveMapperLocations());
        }
        if (this.mybatisPlusProperties.getTypeAliasesPackage() != null) {
            sqlSessionFactoryBean.setTypeAliasesPackage(this.mybatisPlusProperties.getTypeAliasesPackage());
        }
        sqlSessionFactoryBean.setDataSource(dynamicDataSource());
        return sqlSessionFactoryBean;
    }
//    @Bean
//    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setTypeAliasesPackage("com.jwt.springboot.dao");
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*Mapper.xml"));
//        sqlSessionFactoryBean.setDataSource(dynamicDataSource());
//        return sqlSessionFactoryBean;
//    }
}
