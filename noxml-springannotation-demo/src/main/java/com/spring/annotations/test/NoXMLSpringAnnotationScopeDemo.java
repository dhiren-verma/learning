package com.spring.annotations.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.annotations.beans.BasketballCoach;
import com.spring.annotations.interfaces.Coach;
import com.spring.annotations.springConfig.SpringConfiguration;

public class NoXMLSpringAnnotationScopeDemo {

	public static void main(String[] args) {
		//Read Spring Configuration Java Class;
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		
		//Get a Bean from the Spring Context:
		Coach firstBaseballCoach = context.getBean("bCoach", Coach.class);
		Coach secondBaseballCoach = context.getBean("bCoach", Coach.class);
		
		Coach firstSwimmingCoach = context.getBean("swimmingCoach", Coach.class);
		Coach secondSwimmingCoach = context.getBean("swimmingCoach", Coach.class);
		
		if (firstBaseballCoach==secondBaseballCoach)
			System.out.println("BaseballCoach is Singleton");
		else
			System.out.println("Baseball Coach is Prototype");
		
		System.out.println("Memory Address of First Baseball Coach is: "+firstBaseballCoach);
		System.out.println("Memory Address of Second Baseball Coach is: "+secondBaseballCoach+"\n");
		
		if (firstSwimmingCoach==secondSwimmingCoach)
			System.out.println("SwimmingCoach is Singleton");
		else
			System.out.println("Swimming Coach is Prototype");

		System.out.println("Memory Address of First Swimming Coach is: "+firstSwimmingCoach);
		System.out.println("Memory Address of Second Swimming Coach is: "+secondSwimmingCoach);
		
		
		//Close the Application Context(Spring Container):
		context.close();
				
	}

}
