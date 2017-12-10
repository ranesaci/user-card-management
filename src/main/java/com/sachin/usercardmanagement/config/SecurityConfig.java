package com.sachin.usercardmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.sachin.usercardmanagement.service.UserServiceImpl;



@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private AuthenticationSuccessHandler successHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable();
	        http.authorizeRequests()
	        		.antMatchers("/login").permitAll()
	                .antMatchers("**/secure/**").authenticated()
	                .anyRequest().permitAll()
	                .and()
	                .formLogin().loginPage("/login").successHandler(successHandler).permitAll();
	} 
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	    	auth.userDetailsService(userServiceImpl).passwordEncoder(bCryptPasswordEncoder);
		}
	

}
