package com.spring.annotations.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.annotations.interfaces.Coach;

public class AnnotationBeanLifeCycleDemo {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		Coach cricketCoach = context.getBean("cricketCoach", Coach.class);
		
		System.out.println(cricketCoach.getDailyWorkout());
		
		System.out.println(cricketCoach.getDailyFortune());
		
		Coach java9CricketCoach = context.getBean("java9CricketCoach", Coach.class);
		
		System.out.println("Workout recommendation from Java 9 Cricekt Coach is: "+java9CricketCoach.getDailyWorkout());
		
		System.out.println(java9CricketCoach.getDailyFortune());
		
		context.close();
	}
	
}