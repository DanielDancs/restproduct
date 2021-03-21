package com.restproducts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
@Configuration
public class SecConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
		auth
			.inMemoryAuthentication()
				.withUser("belaUser")
				.password("{noop}jelszo")
				.roles("USER")
			  .and()
				.withUser("belaAdmin")
				.password("{noop}jelszo")
				.roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		.csrf().disable()
		.cors().disable()
			.authorizeRequests()
				.antMatchers("/api/product").permitAll()
				.antMatchers("/upload").authenticated()
				.antMatchers(HttpMethod.DELETE,"/api/product/**").hasRole("ADMIN")
				.and().httpBasic()
			.and()
				.formLogin().permitAll();
	}
}
