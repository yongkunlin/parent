package com.bamboo.school.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 系统数据源配置
 * Created by yklin on 2018/5/11.
 */
@Configuration
@MapperScan(basePackages = {"com.bamboo.school.mapper"}, sqlSessionTemplateRef = "schoolSqlSessionTemplate")
public class SchoolDataSourceConfig {

    @Bean(name = "schoolDataSource")
    @Primary //同一个接口有多个实现类可以注入的时候，默认选择哪一个
    @ConfigurationProperties(prefix = "school.datasource") // prefix值必须是application.properteis中对应属性的前缀
    public DataSource schoolDataSource() {
        return DataSourceBuilder.create().build();
    }

    //@Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入
    @Bean
    @Primary //同一个接口有多个实现类可以注入的时候，默认选择哪一个
    public SqlSessionFactory schoolSqlSessionFactory(@Qualifier("schoolDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
//        //添加XML目录
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        try {
//            bean.setMapperLocations(resolver.getResources("classpath*:com/user/server/dao/mapping/*.xml"));
//            return bean.getObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
        return bean.getObject();
    }

    @Bean
    @Primary //同一个接口有多个实现类可以注入的时候，默认选择哪一个
    public SqlSessionTemplate schoolSqlSessionTemplate(@Qualifier("schoolSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }
}
