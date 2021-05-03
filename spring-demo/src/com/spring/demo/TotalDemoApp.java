package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TotalDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("TestApplicationContext.xml");
		
		Coach baseballCoach = context.getBean("bCoach", Coach.class);
		
		Coach secondBaseballCoach = context.getBean("bCoach", Coach.class);
		
		Coach footballCoach = context.getBean("fCoach", Coach.class);
		
		Coach secondFootballCoach = context.getBean("fCoach", Coach.class);
		
		BasketballCoach basketballCoach = context.getBean("baskCoach", BasketballCoach.class);
		
		System.out.println("Is the Baseball Coach Singleton!\n"+(baseballCoach==secondBaseballCoach));
		
		System.out.println("Is Football Coach Singleton!\n"+(footballCoach==secondFootballCoach));
		
		System.out.println("Baseball Coach says: "+baseballCoach.getDailyWorkout());
		
		System.out.println("Football Coach says: "+footballCoach.getDailyWorkout());
		
		
		System.out.println("BasketBall Coach says: "+basketballCoach.getDailyWorkout());
		System.out.println("As per him, "+basketballCoach.getFortune());
		System.out.println("His Email is: "+basketballCoach.getEmail());
		System.out.println("& his Team is: "+basketballCoach.getTeam());
		
		context.close();
		
		//Just to check if the Beans are totally Destroyed after the Container is Closed:
		//Prototype Bean:
		System.out.println("Is Football Coach available to comment: "+footballCoach.getDailyWorkout());
		
		//Singleton Bean:
		System.out.println("Is Baseball Coach available to comment: "+basketballCoach.getDailyWorkout());
	}

}
