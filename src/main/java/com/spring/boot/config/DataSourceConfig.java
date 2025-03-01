package com.spring.boot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {

	@Value("${spring.datasource.driver-class-name}")
	private String MySQL_DRIVER;
	
	@Value("${spring.datasource.url}")
	private String MySQL_URL;
	
	@Value("${spring.datasource.username}")
	private String MySQL_USERNAME;
	
	@Value("${spring.datasource.password}")
	private String MySQL_PASSWORD;
	
	@Bean
	public DataSource dataSourceMySQL() {
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	dataSource.setDriverClassName(MySQL_DRIVER);
	dataSource.setUrl(MySQL_URL);
	dataSource.setUsername(MySQL_USERNAME);
	dataSource.setPassword(MySQL_PASSWORD);
	return dataSource;
	}

	


}
