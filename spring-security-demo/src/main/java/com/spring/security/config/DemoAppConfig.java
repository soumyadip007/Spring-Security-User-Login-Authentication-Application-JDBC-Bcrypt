package com.spring.security.config;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration			//Replacement of web.xml
@EnableWebMvc			//Replacement of spring-mvc-demo.xml
@ComponentScan(basePackages="com.spring.security")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

	//Set up a var to hold the property
	
	@Autowired
	private Environment env;
	
	
	//setup logger for the diagonstic
	
	private Logger logger=Logger.getLogger(getClass().getName());
	
	
	@Bean
	public ViewResolver viewResolver() {
	//define a bean for ViewResolver
	
		
		
	InternalResourceViewResolver obj=new InternalResourceViewResolver();
	
	obj.setPrefix("/WEB-INF/view/");
	obj.setSuffix(".jsp");
	

	return obj;
	}
	
	//Define a bean for our security data source
	
	@Bean
	public DataSource securityDataSource()
	{
		//create connection pool
		
		
		//setup jdbc driver class
		
		
		//log the connection props
		
		//set db connection props
		
		//set up connection pool props
		
		
		return null;
	}
	
}
