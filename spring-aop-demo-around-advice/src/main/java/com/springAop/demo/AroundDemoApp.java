package com.springAop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springAop.demo.service.TrafficFortuneService;

public class AroundDemoApp {
	
	public static void main(String[] args) {
		// Read the Spring Configuration Java Class:
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//Get the Bean from Spring Container:
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("Main Program: AroundDemoApp");
		
		System.out.println("Calling Fortune Service");
		
		String fortune = trafficFortuneService.getFortune();
		
		System.out.println("Fortune is: "+fortune);
		
		//Close the Context:
		context.close();
		
	}

}