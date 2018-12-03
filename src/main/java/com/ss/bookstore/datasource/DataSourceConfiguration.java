package com.ss.bookstore.datasource;
import javax.sql.DataSource;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages={"com.ss.bookstore.mapper"})
@EnableTransactionManagement
public class DataSourceConfiguration {
    @Primary
    @Bean("dataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        System.out.println("maxActive : "+ds.getMaxActive());
        return ds ;
    }
    //Springboot配置druid时不再需要配置SqlSessionFactory，否则mybatis-plus的BaseMapper分页功能都会失效
//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean() throws Exception{
//        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
//        DataSource ds1 = dataSource();
//        DataSource ds2 = dataSource();
//        System.out.println("ds1 == ds2 : " + (ds1 == ds2));
//        System.out.println("max-active : " + ((DruidDataSource)dataSource()).getMaxActive());
//        factoryBean.setDataSource(dataSource());
//        return factoryBean.getObject();
//    }
//    @Bean
//    public PlatformTransactionManager transactionManager(){
//        return new DataSourceTransactionManager(dataSource());
//    }
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor pi = new PaginationInterceptor();
        pi.setDialectType("mysql");
        return pi;
    }
}