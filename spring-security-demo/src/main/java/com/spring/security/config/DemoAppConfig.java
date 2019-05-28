package com.spring.security.config;

import java.beans.PropertyVetoException;
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

import com.mchange.v2.c3p0.ComboPooledDataSource;

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
		ComboPooledDataSource securityDS= new ComboPooledDataSource();
		
		//setup jdbc driver class
		
		try {
			securityDS.setDriverClass(env.getProperty("jdbc.driver"));
			System.out.println("Connecting");
		} catch (PropertyVetoException e) {
		
			
			e.printStackTrace();
		}
		
		//log the connection props
		logger.info(">>Jdbc.url="+env.getProperty("jdbc.url"));

		logger.info(">>Jdbc.user="+env.getProperty("jdbc.user"));
		System.out.println("Connecting 2");
		
		//set db connection props & pools
		
		
		securityDS.setJdbcUrl(env.getProperty("jdbc.driver"));

		securityDS.setUser(env.getProperty("jdbc.user"));
		
		securityDS.setPassword(env.getProperty("jdbc.password"));
		
		securityDS.setInitialPoolSize(
				getIntProperty("connection.pool.initialPoolSize"));

		securityDS.setMinPoolSize(
				getIntProperty("connection.pool.minPoolSize"));

		securityDS.setMaxPoolSize(
				getIntProperty("connection.pool.maxPoolSize"));

		securityDS.setMaxIdleTime(
				getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDS;
	}
	
	// need a helper method 
	// read environment property and convert to int
	
	private int getIntProperty(String propName) {
		
		String propVal = env.getProperty(propName);
		
		// now convert to int
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}
}
