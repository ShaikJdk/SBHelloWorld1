package com.spring.boot.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	    basePackages = "com.spring.boot.repository.mysql",
	    entityManagerFactoryRef = "mysqlSessionFactory",
	    transactionManagerRef = "mysqlTransactionManager"
	)
public class MySqlHibernateConfiguration {

	@Autowired
	@Qualifier("dataSourceMySQL")
	private DataSource dataSourceMySQL;
	
	@Value("${spring.jpa.mysql.properties.hibernate.dialect}")
	private String DIALECT;

	@Value("${spring.jpa.show-sql}")
	private String SHOW_SQL;

	@Value("${spring.jpa.oracle.hibernate.ddl-auto}")
	private String HBM2DDL_AUTO;
	
	@Value("com.spring.boot.dbmodel.mysql")
	private String ENTITYMANAGER_PACKAGE_SCAN;
	
//	@Bean(name = "entityManagerFactory")
	@Bean(name = "mysqlSessionFactory")
	public LocalSessionFactoryBean mysqlSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSourceMySQL);
		sessionFactory.setPackagesToScan(ENTITYMANAGER_PACKAGE_SCAN);
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", DIALECT);
		hibernateProperties.put("hibernate.show_sql", SHOW_SQL);
		hibernateProperties.put("hibernate.hbm2ddl.auto", HBM2DDL_AUTO);
		sessionFactory.setHibernateProperties(hibernateProperties);

		return sessionFactory;
	}

	@Bean(name = "mysqlTransactionManager")
	public HibernateTransactionManager mysqlTransactionManager(@Qualifier("mysqlSessionFactory") LocalSessionFactoryBean factory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(factory.getObject());
		return transactionManager;
	}

}
