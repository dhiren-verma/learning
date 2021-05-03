package com.spring.annotations.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.annotations.interfaces.Coach;

public class AnnotationBeanScopeDemo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		Coach firstBaseballCoach  = context.getBean("baseballCoach", Coach.class);
		Coach secondBaseballCoach  = context.getBean("baseballCoach", Coach.class);
		
		Coach firstFootballCoach = context.getBean("footballCoach", Coach.class);
		Coach secondFootballCoach = context.getBean("footballCoach", Coach.class);
		
		if (firstBaseballCoach==secondBaseballCoach)
			System.out.println("Baseball Coach is Singleton");
		else
			System.out.println("Baseball Coach is Prototype");
		
		System.out.println("Memory Location of First Baseball Coach is: "+firstBaseballCoach);
		System.out.println("Memory Location of First Baseball Coach is: "+secondBaseballCoach);
		
		
		if (firstFootballCoach==secondFootballCoach)
			System.out.println("Football Coach is Singleton");
		else
			System.out.println("Football Coach is Prototype");
		
		System.out.println("Memory Location of First Football Coach is: "+firstFootballCoach);
		System.out.println("Memory Location of First Football Coach is: "+secondFootballCoach);
		
		
		context.close();
	}

}
