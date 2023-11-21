package com.lkbackend.lkbackend;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()	
		.authorizeRequests()
		.requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
				.anyRequest().authenticated()
				.and()
			//.formLogin().and()
			.httpBasic();
	}
