package com.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration          //Replacement of web.xml
@EnableWebSecurity		//Replacement of spring-mvc-demo.xml
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add our users for in-memory authentication   (Spring Default)
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test123").roles("ADMIN"))
			.withUser(users.username("mary").password("test123").roles("MANAGER"))
			.withUser(users.username("susan").password("test123").roles("ADMIN"));
	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		
		http.authorizeRequests()
		.antMatchers("/","/leaders").hasAuthority("ADMIN").anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/showMyLoginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.permitAll()
			.and()
			.logout().permitAll();
		
		
		
		//logoutSuccessUrl("/customLogout")
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	
		web.ignoring().antMatchers("/resources/**","/static/**","/Script/**","/Style/**","/Icon/**",
				"/js/**","/bootstrap/**","/Image/**");
		
		//logoutSuccessUrl("/customLogout")
	}
	
	
	
}
