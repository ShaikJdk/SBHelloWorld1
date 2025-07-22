package com.spring.boot.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	basePackages = "com.spring.boot.repository.oracle",
	entityManagerFactoryRef = "oracleEntityManagerFactory",
	transactionManagerRef = "oracleTransactionManager"
)
@EnableConfigurationProperties(JpaProperties.class)
public class OracleEntityManagerConfiguration {

	@Autowired
	@Qualifier("dataSourceOracle")
	HikariDataSource dataSource;
	
	 @Bean(name = "oracleEntityManagerFactory")
	 @Primary
	 public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory(
			 EntityManagerFactoryBuilder builder) {
		 Map<String, Object> properties = new HashMap<>();
		 properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		 properties.put("hibernate.show_sql", true);
		 properties.put("hibernate.hbm2ddl.auto", "update");
	        return builder
	                .dataSource(dataSource)
	                .packages("com.spring.boot.dbmodel.oracle")
	                .persistenceUnit("oracle")
	                .properties(properties)
	                .build();
	 }
	 
	 @Bean(name = "oracleTransactionManager")
	 @Primary
	    public PlatformTransactionManager oracleTransactionManager(
	            @Qualifier("oracleEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
	        return new JpaTransactionManager(entityManagerFactory);
	    }
}