package com.spring.util;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LoggerConfig {
	
	private String rootLoggerLevel;
	private String printLoggerLevel;
	
	public void setRootLoggerLevel(String rootLoggerLevel) {
		this.rootLoggerLevel = rootLoggerLevel;
	}
	
	public void setPrintLoggerLevel(String printLoggerLevel) {
		this.printLoggerLevel = printLoggerLevel;
	}
	
	public void initLogger() {
		//Parse Levels:
		Level rootLevel = Level.parse(rootLoggerLevel);
		Level printLevel = Level.parse(printLoggerLevel);
		
		//Get Logger for Application Context:
		Logger applicationContextLogger = Logger.getLogger(AnnotationConfigApplicationContext.class.getName());
		
		//Get Parent Logger:
		Logger parentLogger = applicationContextLogger.getParent();
		
		//Set Root Logging Level:
		parentLogger.setLevel(rootLevel);
		
		//Set Console Handler:
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(printLevel);
		consoleHandler.setFormatter(new SimpleFormatter());
		
		//Add Handler(Console Handler) to the Logger:
		parentLogger.addHandler(consoleHandler);
		
	}
	
}