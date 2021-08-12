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
	public Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver getViewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/view/", ".jsp");
	}
	
	@Bean
	public DataSource myDataSource() {
		//Create Connection Pool:
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();
		
		//Set JDBC Driver:
		try {
			myDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException ex) {
			logger.log(Level.SEVERE, "JDBC Driver exception", ex);
		}
		
		//Set DB Connection Properties:
		myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		myDataSource.setUser(env.getProperty("jdbc.user"));
		myDataSource.setPassword(env.getProperty("jdbc.password"));
		
		//Set Connection Pool Properties:
		myDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		myDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return myDataSource;
	}
	
	private int getIntProperty(String propertyName) {
		return Integer.parseInt(env.getProperty(propertyName));
	}
	
}