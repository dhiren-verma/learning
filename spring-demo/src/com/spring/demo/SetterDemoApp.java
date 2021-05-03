package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// Create a Spring Container - Load the Spring Configuration File:
		ClassPathXmlApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		// Retrieve a Bean from the Spring Container:
		BasketballCoach coach = applicationContext.getBean("basketballCoach", BasketballCoach.class);
		
		// Call methods on the retrieved Bean:
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getFortune());
		
		System.out.println(coach.getEmail());
		System.out.println(coach.getTeam());
		
		// Close Application Context:
		applicationContext.close();

	}

}
