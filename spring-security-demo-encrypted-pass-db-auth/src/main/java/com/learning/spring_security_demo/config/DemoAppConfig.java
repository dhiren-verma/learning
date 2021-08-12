package com.learning.spring_security_demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.learning.spring_security_demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public DataSource securityDataSource() {
		//Create Connection Pool:
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		//Set JDBC Driver:
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			logger.log(Level.SEVERE, "JDBC Driver exception", e);
		}
		
		//Set DB Connection Properties:
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		//Set Connection Pool Properties:
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
	private int getIntProperty(String propertyName) {
		return Integer.parseInt(env.getProperty(propertyName));
	}
	
	@Bean
	public ViewResolver getViewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/view/", ".jsp");
	}
	
}