package com.learning.spring_security_demo_complete.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.learning.spring_security_demo_complete")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver getViewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/view/", ".jsp");
	}
	
	@Bean
	public DataSource secureDataSource() {
		ComboPooledDataSource secureDataSource = new ComboPooledDataSource();
		
		try {
			secureDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException ex) {
			logger.log(Level.SEVERE, "JDBC Driver exception", ex);
		}
		
		//Set Connection Properties:
		secureDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		secureDataSource.setUser(env.getProperty("jdbc.user"));
		secureDataSource.setPassword(env.getProperty("jdbc.password"));
		
		//Set Connection Pool Properties:
		secureDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		secureDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		secureDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		secureDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return secureDataSource;
	}
	
	private int getIntProperty(String propertyName) {
		return Integer.parseInt(env.getProperty(propertyName));
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(secureDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		
		properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		return properties;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		
		txManager.setSessionFactory(sessionFactory);
		
		return txManager;
	}
	
}