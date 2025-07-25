package com.spring.boot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties("spring.datasource.mysql")
@Getter
@Setter
public class MySqlDataSourceConfig {

	@Value("${spring.datasource.mysql.driver-class-name}")
	private String MySQL_DRIVER;
	
	@Value("${spring.datasource.mysql.url}")
	private String MySQL_URL;
	
	@Value("${spring.datasource.mysql.username}")
	private String MySQL_USERNAME;
	
	@Value("${spring.datasource.mysql.password}")
	private String MySQL_PASSWORD;
	
	private String url;
	private String username;
	private String password;
			
	@Bean(name="dataSourceMySQL")
	public DataSource dataSourceMySQL() {
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	dataSource.setDriverClassName(MySQL_DRIVER);
	dataSource.setUrl(MySQL_URL);
	dataSource.setUsername(MySQL_USERNAME);
	dataSource.setPassword(MySQL_PASSWORD);
	return dataSource;
	}

	


}
