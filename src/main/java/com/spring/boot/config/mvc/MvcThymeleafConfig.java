//package com.spring.boot.config.mvc;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring6.view.ThymeleafViewResolver;
//
//@Configuration
//public class MvcThymeleafConfig {
//
//    /**
//     * Template Resolver — tells Thymeleaf where to find templates
//     */
//    @Bean
//    public SpringResourceTemplateResolver templateResolver() {
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setPrefix("classpath:/templates/"); // template folder
//        templateResolver.setSuffix(".html");                 // file extension
//        templateResolver.setTemplateMode("HTML");            // mode
//        templateResolver.setCharacterEncoding("UTF-8");      // encoding
//        templateResolver.setCacheable(false);                 // disable cache in dev
//        return templateResolver;
//    }
//
//    /**
//     * Template Engine — processes templates
//     */
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.setEnableSpringELCompiler(true); // enables Spring EL expressions
//        return templateEngine;
//    }
//
//    /**
//     * View Resolver — maps views to Thymeleaf templates
//     */
//    @Bean
//    public ThymeleafViewResolver viewResolver() {
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(templateEngine());
//        viewResolver.setCharacterEncoding("UTF-8");
//        return viewResolver;
//    }
//}