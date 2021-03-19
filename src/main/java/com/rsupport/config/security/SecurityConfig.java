package com.rsupport.config.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		http
			.csrf().disable()
				.authorizeRequests()
				.antMatchers("/board/**")
				.hasRole("MEMBER")
			.and()
				.sessionManagement()
				.maximumSessions(10)
				.maxSessionsPreventsLogin(false)
			.and()
			.and()
				.exceptionHandling()
				.accessDeniedPage("/accessDenied")
			.and()
				.formLogin()
				.failureUrl("/loginfailed")
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring().antMatchers("/css/**", "/js/**");
	}
	
	
	
	

}
