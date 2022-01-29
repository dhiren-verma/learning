package com.spring.autowiring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.demo.Coach;

public class AutowiringDemoApp {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("Autowiring-ApplicationContext.xml");
		
		Coach testCoach = context.getBean("byNameAutowiredCoach", Coach.class);
		
		System.out.println(testCoach.getDailyWorkout());
		
		System.out.println(testCoach.getFortune());
		
		context.close();
	}
	
}
