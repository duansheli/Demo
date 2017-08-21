package com.example.demo.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;


@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = ClusterDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "clusterSqlSessionFactory")
public class ClusterDataSourceConfig {
 
    // 精确到 cluster 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.example.demo.dao_cluster";
    static final String MAPPER_LOCATION = "classpath:mapper/cluster/*.xml";
    @Autowired
    private Environment environment ;
 
    @Bean(name = "clusterDataSource")
    public DataSource clusterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(environment.getProperty("cluster.datasource.driverClassName"));
        dataSource.setUrl(environment.getProperty("cluster.datasource.url"));
        dataSource.setUsername(environment.getProperty("cluster.datasource.username"));
        dataSource.setPassword(environment.getProperty("cluster.datasource.password"));
        return dataSource;
    }
 
    @Bean(name = "clusterTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager(@Qualifier("clusterDataSource") DataSource clusterDataSource) {
        return new DataSourceTransactionManager(clusterDataSource);
    }
 
    @Bean(name = "clusterSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("clusterDataSource") DataSource clusterDataSource)
            throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources(ClusterDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
