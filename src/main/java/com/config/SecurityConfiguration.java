package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetailService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
	auth.userDetailsService(userDetailService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/member/**").hasRole("admin")
        .antMatchers("/ticket/**").hasAnyRole("admin", "user")
        .antMatchers("/movie/**").hasAnyRole("admin", "user")
        .antMatchers("/seat/**").hasAnyRole("staff","admin")
        .antMatchers("/**").permitAll()
        .and().httpBasic();
	}
	
	@Bean
	public PasswordEncoder noPasswordYet() {
		return NoOpPasswordEncoder.getInstance();
	}

}
