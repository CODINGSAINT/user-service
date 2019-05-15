package com.codinsaint.tutorial.spring.userservice.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.codinsaint.tutorial.spring.userservice.config.messageconverter.UserMessageConverter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport{
	@Override
 public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new UserMessageConverter());
	 
 }
}
