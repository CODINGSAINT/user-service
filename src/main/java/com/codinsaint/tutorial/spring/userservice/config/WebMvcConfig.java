package com.codinsaint.tutorial.spring.userservice.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.codinsaint.tutorial.spring.userservice.config.messageconverter.UserMessageConverter;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurationSupport{
	@Override
 public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new UserMessageConverter());
	 
 }
	@Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
