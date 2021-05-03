package com.spring.annotations.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.annotations.beans.BoxingCoach;
//import com.spring.annotations.interfaces.Coach;
import com.spring.annotations.springConfig.SpringConfiguration;

public class NoXMLManualSpringAnnotationDemo {

	public static void main(String[] args) {
		//Read Spring Configuration Java Class:
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		
		//Get a Bean from the Spring Context:
		BoxingCoach boxingCoach = context.getBean("boxingCoach", BoxingCoach.class);
		
		BoxingCoach secondBoxingCoach = context.getBean("boxingCoach", BoxingCoach.class);
		
		if (boxingCoach==secondBoxingCoach)
			System.out.println("Boxing Coach is singleton");
		else
			System.out.println("Boxing Coach is prototype");
		
		if (boxingCoach.getFortuneService()==secondBoxingCoach.getFortuneService()) {
			System.out.println("Both Boxing Coaches have reference to the same Fortune Service");
		} else {
			System.out.println("Boxing Coaches have separate instances of their Fortune Services");
		}
		
		//Invoke Methods on the Bean:
		System.out.println("Boxing Coach says: "+boxingCoach.getDailyWorkout());
		
		System.out.println(boxingCoach.getDailyFortune());
		
		//Close the Application Context(Spring Container):
		context.close();
	}

}
