
package com.example.demo.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@EnableConfigurationProperties(MasterProp.class)
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = MasterDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {

    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.example.demo.dao";
    static final String MAPPER_LOCATION = "classpath:mapper/master/*.xml";

    @Autowired
    MasterProp prop;

    @Bean(name = "masterDataSource")
    @Primary
    public DataSource masterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(prop.driverClassName);
        dataSource.setUrl(prop.url);
        dataSource.setUsername(prop.user);
        dataSource.setPassword(prop.password);
        return dataSource;
    }

    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager(
            @Qualifier("masterDataSource") DataSource masterDataSource) {
        return new DataSourceTransactionManager(masterDataSource);
    }

    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource)
            throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);

        // 当使用xml配置时，需要设置扫描mpper/*.xml文件
        // sessionFactory.setTypeAliasesPackage("com.example.demo.dao");//指定基包
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources(MasterDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}

@ConfigurationProperties(prefix = "master.datasource")
class MasterProp {
    String url;

    String user;

    String password;

    String driverClassName;

    public void setUrl(String url) {
    
        this.url = url;
    }

    public void setUser(String user) {
    
        this.user = user;
    }

    public void setPassword(String password) {
    
        this.password = password;
    }

    public void setDriverClassName(String driverClassName) {
    
        this.driverClassName = driverClassName;
    }

}