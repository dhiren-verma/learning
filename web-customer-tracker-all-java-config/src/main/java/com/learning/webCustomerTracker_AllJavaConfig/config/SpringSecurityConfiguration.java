package com.learning.webCustomerTracker_AllJavaConfig.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//Max Restrictive at the Top
		//Least Restrictive at the Bottom
		http.authorizeRequests()
				.antMatchers("/customer/deleteCustomer/**")
					.hasRole("ADMIN")
				.antMatchers("/customer/addCustomerForm/**", "/customer/addCustomer/**", "/customer/updateCustomerForm/**", "/customer/updateCustomer/**")
					.hasAnyRole("MANAGER", "ADMIN")
				.antMatchers("/customer/listCustomers/**", "/customer/searchCustomer/**")
					.hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
				.antMatchers("/").permitAll()
			.and()
				.formLogin()
					.loginPage("/showLoginPage")
					.loginProcessingUrl("/authenticateUser")
					.permitAll()
			.and()
				.logout()
				.permitAll()
			.and()
				.exceptionHandling()
				.accessDeniedPage("/access-denied");
			
	}
	
	//Added for being able to Create New User(s):
	@Bean
	public UserDetailsManager userDetailsManager() {
		JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
		
		userDetailsManager.setDataSource(securityDataSource);
		
		return userDetailsManager;
	}
	
//	@Configuration
//	@Order(1)
//	public static class WebAppSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{
//		
//		Logger logger = Logger.getLogger(getClass().getName());
//		
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			//Max Restrictive at the Top
//			//Least Restrictive at the Bottom
//			http.authorizeRequests()
//					.antMatchers("/customer/deleteCustomer/**")
//						.hasRole("ADMIN")
//					.antMatchers("/customer/addCustomerForm/**", "/customer/addCustomer/**", "/customer/updateCustomerForm/**", "/customer/updateCustomer/**")
//						.hasAnyRole("MANAGER", "ADMIN")
//					.antMatchers("/customer/listCustomers/**", "/customer/searchCustomer/**")
//						.hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
//					.antMatchers("/").permitAll()
//				.and()
//					.formLogin()
//						.loginPage("/showLoginPage")
//						.loginProcessingUrl("/authenticateUser")
//						.permitAll()
//				.and()
//					.logout()
//					.permitAll()
//				.and()
//					.exceptionHandling()
//					.accessDeniedPage("/access-denied");
//			
//			logger.info("WebAppSecurityConfigurerAdapter successfully loaded");
//		}
//		
//	}
//	
//	@Configuration
//	@Order(2)
//	public static class RestApiSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//		
//		Logger logger = Logger.getLogger(getClass().getName());
//		
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			//Max Restrictive at the Top
//			//Least Restrictive at the Bottom
//			http.authorizeRequests()
//					.antMatchers(HttpMethod.DELETE, "/api/customers/**").hasRole("ADMIN")
//					.antMatchers(HttpMethod.POST, "/api/customers").hasAnyRole("MANAGER", "ADMIN")
//					.antMatchers(HttpMethod.POST, "/api/customers/**").hasAnyRole("MANAGER", "ADMIN")
//					.antMatchers(HttpMethod.PUT, "/api/customers").hasAnyRole("MANAGER", "ADMIN")
//					.antMatchers(HttpMethod.PUT, "/api/customers/**").hasAnyRole("MANAGER", "ADMIN")
//					.antMatchers(HttpMethod.GET, "/api/customers").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
//					.antMatchers(HttpMethod.GET, "/api/customers/**").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
//				.and()
//					.httpBasic().authenticationEntryPoint(authenticationEntryPoint())
//				.and()
//					.csrf().disable()
//					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//			
//			logger.info("RestApiSecurityConfigurationAdapter successfully loaded");
//		}
//		
//		@Bean
//		public AuthenticationEntryPoint authenticationEntryPoint() {
//			BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
//			
//			entryPoint.setRealmName("api realm");
//			
//			return entryPoint;
//		}
//		
//	}
	
}