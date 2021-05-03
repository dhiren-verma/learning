package com.spring.annotations.util;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:springLogger.properties")
//If want to prevent "FileNotFoundException", the can configure "ignoreResourceNotFound" attribute:
//@PropertySource(value="classpath:springLogger.properties", ignoreResourceNotFound=true)
public class SpringLoggerConfig {
	
	@Value("${root.logger.level}")
	private String rootLoggerLevel;
	
	@Value("${printed.logger.level}")
	private String printedLoggerLevel;
	
	@PostConstruct
	public void init() throws Exception {
		//Parse Levels:
		Level rootLevel = Level.parse(rootLoggerLevel);
		Level printedLevel = Level.parse(printedLoggerLevel);
		
		//Get Logger for Application Context:
		Logger applicationContextLogger = Logger.getLogger(AnnotationConfigApplicationContext.class.getName());
		
		//Get Parent Logger:
		Logger loggerParent = applicationContextLogger.getParent();
		
		//Set Root Logging Level:
		loggerParent.setLevel(rootLevel);
		
		//Setup Console Handler:
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(printedLevel);
		consoleHandler.setFormatter(new SimpleFormatter());
		
		//Add Handler to the Logger:
		loggerParent.addHandler(consoleHandler);
		
	}
	
}