package com.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration			//Replacement of web.xml
@EnableWebMvc			//Replacement of spring-mvc-demo.xml
@ComponentScan(basePackages="com.spring.security")
public class DemoAppConfig {

	
	@Bean
	public ViewResolver viewResolver() {
	//define a bean for ViewResolver
	
	InternalResourceViewResolver obj=new InternalResourceViewResolver();
	
	obj.setPrefix("/WEB-INF/view/");
	obj.setSuffix(".jsp");
	
	
	return obj;
	}
}
