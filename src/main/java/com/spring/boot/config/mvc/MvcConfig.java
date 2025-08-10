package com.spring.boot.config.mvc;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


//if you dont want do config like 
//spring.mvc.view.prefix=/WEB-INF/jsp/
//spring.mvc.view.suffix=.jsp

@Configuration
@EnableWebMvc
public class MvcConfig {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/"); // JSP folder
        resolver.setSuffix(".jsp");            // File extension
        return resolver;
    }
}