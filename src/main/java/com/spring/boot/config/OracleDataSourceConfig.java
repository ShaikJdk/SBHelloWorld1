package com.spring.boot.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class OracleDataSourceConfig {
	
//	@Bean(name = "dataSourceOracle")
//	@Primary
//	@ConfigurationProperties(prefix= "spring.datasource.oracle")
//	public DataSource dataSourceOracle() {
//		return DataSourceBuilder.create().build();
//	}
	
	@Bean(name = "dataSourceOracle")
	@Primary
	@ConfigurationProperties(prefix= "spring.datasource.oracle")
	public HikariDataSource dataSourceOracle() {
		 return new HikariDataSource();
//		 HikariDataSource dataSource = new HikariDataSource();
//		    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
//		    dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/orcl"); 
//		    dataSource.setUsername("SYSTEM");
//		    dataSource.setPassword("admin");
//		    return dataSource;
	}

	
}
