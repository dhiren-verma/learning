package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		// load the Spring Container file:
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanLifeCycle-ApplicationContext.xml");
		
		// retrieve bean from Spring Container:
		Coach myCoach = context.getBean("coach", Coach.class);
		
		System.out.println(myCoach.getDailyWorkout());
		
		//Close Spring Container:
		context.close();
	}

}
