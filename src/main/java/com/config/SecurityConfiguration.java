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
        http.authorizeRequests()
        .antMatchers("/member").hasRole("admin")
        .antMatchers("/ticket").hasAnyRole("admin", "user")
        .antMatchers("/seat").hasRole("staff")
        .antMatchers("/").permitAll()
        .and().exceptionHandling().accessDeniedPage("/403")
        .and().formLogin();
	}
	
	@Bean
	public PasswordEncoder noPasswordYet() {
		return NoOpPasswordEncoder.getInstance();
	}

}
