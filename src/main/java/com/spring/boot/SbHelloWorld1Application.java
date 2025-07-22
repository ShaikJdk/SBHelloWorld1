package com.spring.boot;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication(scanBasePackages = "com.spring.boot")
@EnableAutoConfiguration(exclude = { DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class, DataSourceAutoConfiguration.class })
@EnableAsync
@EnableCaching
public class SbHelloWorld1Application {

	public static void main(String[] args) {
		SpringApplication.run(SbHelloWorld1Application.class, args);
	}
	
	@Bean(name = "asyncTaskExecutor")
	public Executor asyncTaskExecutor() {
		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(50);
		executor.setMaxPoolSize(150);
		executor.setQueueCapacity(150);
		executor.setThreadNamePrefix("AsyncThread-");
		executor.initialize();
		return executor;
	}

}
