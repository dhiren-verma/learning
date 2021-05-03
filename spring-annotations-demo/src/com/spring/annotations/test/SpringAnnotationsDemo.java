package com.spring.annotations.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.annotations.beans.SwimmingCoach;
import com.spring.annotations.interfaces.Coach;

public class SpringAnnotationsDemo {

	public static void main(String[] args) {
		//Get the Spring Container - Read the Spring Config File:
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		//Get Bean from the Container:
		Coach coach = context.getBean("tennisCoach", Coach.class);
		Coach secondCoach = context.getBean("sCoach", Coach.class);
		Coach thirdCoach = context.getBean("baseballCoach", Coach.class);
		Coach fourthCoach = context.getBean("footballCoach", Coach.class);
		
		SwimmingCoach swimmingCoach = context.getBean("swimmingCoach", SwimmingCoach.class);
		
		//Call methods on the Bean:
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		System.out.println("Second Coach says: "+secondCoach.getDailyWorkout());
		System.out.println(secondCoach.getDailyFortune());
		
		System.out.println("Third Coach says: "+thirdCoach.getDailyWorkout());
		System.out.println(thirdCoach.getDailyFortune());
		
		System.out.println("Fourth Coach says: "+fourthCoach.getDailyWorkout());
		System.out.println(fourthCoach.getDailyFortune());
		
		System.out.println("Swimming Coach says: "+swimmingCoach.getDailyWorkout());
		System.out.println(swimmingCoach.getDailyFortune());
		System.out.println("His Email is: "+swimmingCoach.getEmail());
		System.out.println("His Team is: "+swimmingCoach.getTeam());
		
		//Close Container/Context:
		context.close();
		
	}

}
