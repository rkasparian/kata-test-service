package com.kata.service.raoul.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 

		http.authorizeRequests()
			.antMatchers("/clientDeposit").access("hasRole('STANDARD_CLIENT')")
			.antMatchers("/clientWithdrawal").access("hasRole('STANDARD_CLIENT')")
			.antMatchers("/clientChecking").access("hasRole('STANDARD_CLIENT')")
            .anyRequest().authenticated();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
