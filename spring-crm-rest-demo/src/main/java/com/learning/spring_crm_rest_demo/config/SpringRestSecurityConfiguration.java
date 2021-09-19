package com.learning.spring_crm_rest_demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SpringRestSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// add our users for in memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
			.withUser(users.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"));
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
			antMatchers("/api/customers/**").authenticated().
			and().
			httpBasic().
			and().
			csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		// Why disable CSRF?
		//
		// Spring Security 5 has CSRF enabled by default. We would need to send over CSRF tokens.
		// However, CSRF generally does not apply for REST APIs. CSRF protection is a request that
		// could be processed by a browser by normal users.
		// If we are only creating a REST service that is used by non-browser clients, we will
		// likely want to disable CSRF protection.
		//
		// For more details, see this link:
		// http://www.tothenew.com/blog/fortifying-your-rest-api-using-spring-security/
		
		// Why disable sessions?
		//
		// For our application, we would like avoid the use of cookies for session tracking. This
		// should force the REST client  to enter user name and password for each request. However,
		// this is not always the case depending on the REST client / browser we are using. Our
		// mileage will vary here (for example, this doesn't work in Eclipse embedded browser).
		//
		// For more details, see this link
		// http://www.baeldung.com/spring-security-session
	}
		
}