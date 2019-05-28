package com.spring.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration          //Replacement of web.xml
@EnableWebSecurity		//Replacement of spring-mvc-demo.xml
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add our users for in-memory authentication   (Spring Default)
		
/*		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGERS"))
			.withUser(users.username("susan").password("test123").roles("EMPLOYEE","ADMIN"));
	*/
		
		
		//using JDBC Authentication
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		
		http.authorizeRequests()
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/leaders/**").hasRole("MANAGERS")
			.antMatchers("/system/**").hasRole("ADMIN")   //	.permitAll()
			.antMatchers("/resources/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/showMyLoginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/accessDenied");
		
		//logoutSuccessUrl("/customLogout")
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	
		web.ignoring().antMatchers("/resources/**","/static/**","/Script/**","/Style/**","/Icon/**",
				"/js/**","/bootstrap/**","/Image/**");
		
		//logoutSuccessUrl("/customLogout")
	}
	

	@Bean
	public UserDetailsManager userDetailsManager() {
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		
		jdbcUserDetailsManager.setDataSource(securityDataSource);
		
		return jdbcUserDetailsManager; 
	}
		
	
}
