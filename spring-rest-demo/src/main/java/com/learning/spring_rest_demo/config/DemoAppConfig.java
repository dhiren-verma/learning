package com.learning.spring_rest_demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.learning.spring_rest_demo")
public class DemoAppConfig {
	
	//No need for View Resolver here as its just a Spring REST Application
	
}