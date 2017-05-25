package me.yuki;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("me.yuki.dao")
public class BootApplication {

	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSource getDataSource() {
		return new org.apache.tomcat.jdbc.pool.DataSource();
	}

	@Bean
	public SqlSessionFactory getSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(getDataSource());
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactory.setMapperLocations(resolver.getResources("/mapping/*.xml"));
		return sqlSessionFactory.getObject();
	}

	@Bean
	public PlatformTransactionManager getTransactionManager() {
		return new DataSourceTransactionManager(getDataSource());
	}

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

}
