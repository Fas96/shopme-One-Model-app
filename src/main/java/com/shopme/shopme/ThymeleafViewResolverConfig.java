package com.shopme.shopme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

//@Configuration
public class ThymeleafViewResolverConfig {

//    @Bean
//    public SpringResourceTemplateResolver templateResolver() {
//        SpringResourceTemplateResolver  templateResolver = new SpringResourceTemplateResolver ();
//        templateResolver.setPrefix("classpath:/template/");
//        templateResolver.setCharacterEncoding("UTF-8");
//        templateResolver.setSuffix(".html");
//        return templateResolver;
//    }
//
//    @Bean
//    public SpringTemplateEngine templateEngine(MessageSource messageSource) {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.setTemplateEngineMessageSource(messageSource);
//        return templateEngine;
//    }
//
//
//
//    @Bean
//    @Autowired
//    public ViewResolver viewResolver(MessageSource messageSource) {
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(templateEngine(messageSource));
//        viewResolver.setCharacterEncoding("UTF-8");
//        viewResolver.setOrder(0);
//        return viewResolver;
//    }
}
