package com.spring.annotations.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.annotations.beans.BasketballCoach;
import com.spring.annotations.interfaces.Coach;
import com.spring.annotations.springConfig.SpringConfiguration;

public class NoXMLSpringAnnotationDemo {
	
	public static void main(String[] args) {
		//Read Spring Configuration Java Class:
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		
		//Get a Bean from the Spring Context:
		Coach coach = context.getBean("bCoach", Coach.class);
		
		Coach swimmingCoach = context.getBean("swimmingCoach", Coach.class);
		
		BasketballCoach basketballCoach = context.getBean("basketballCoach", BasketballCoach.class);
		
		Coach cricketCoach = context.getBean("cricketCoach", Coach.class);
		
		//Call a Method on the Bean:
		System.out.println("Baseball Coach syas: "+coach.getDailyWorkout());
		System.out.println("As per Baseball Coach: "+coach.getDailyFortune()+"\n");
		
		System.out.println("Swimming Coach says: "+swimmingCoach.getDailyWorkout());
		System.out.println("As per Swimming Coach: "+swimmingCoach.getDailyFortune()+"\n");
		
		System.out.println("Basketball Coach says: "+basketballCoach.getDailyWorkout());
		System.out.println("As per Basketball Coach: "+basketballCoach.getDailyFortune());
		System.out.println("His Email Id is: "+basketballCoach.getEmail());
		System.out.println("His Team is: "+basketballCoach.getTeam()+"\n");
		
		System.out.println("Cricket Coach says: "+cricketCoach.getDailyWorkout());
		System.out.println("As per Cricket Coach: "+cricketCoach.getDailyFortune());
		
		//Close the Application Context(Spring Container):
		context.close();
		
	}

}
