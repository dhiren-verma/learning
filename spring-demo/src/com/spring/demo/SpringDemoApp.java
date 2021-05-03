package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main Responsibilities of Spring Container:
 * 1. Creation & Management of Objects(Inversion of Control)
 * 2. Inject Object's Dependencies(Dependency Injection)
 * 
 * Inversion of Control:
 * Its the approach of outsourcing the construction & management of Objects.
 * In case of Spring we off-load this responsibility to Spring Container(Object Factory),
 * hence Inversion Of Control is achieved.
 * 
 * Spring Container is known as ApplicationContext
 * 
 * There are specialized implementations of AplicationContext,
 * depending on from where the Spring Beans will be obtained:
 * 1. ClassPathXmlApplicationContext
 * 2. AnnotationConfigApplicationContext
 * 3. GenericWebApplicationContext
 * 
 * @author Dhirendra
 */
public class SpringDemoApp {

	public static void main(String[] args) {
		//Create a Spring Container - Load the Spring Configuration File:
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		//Retrieve a Bean from Spring Container:
		//Note: by mentioning the Interface Class, we are trying to ensure Type Safety by Sprint itself,
		//in which case if the returned Bean is not compatible, then "BeanNotOfRequiredTypeException"
		//exception will be thrown.
		//If using conventional Type Casting, then if not compatible then ClassCastException would
		//have been thrown.
		Coach myCoach = context.getBean("coach", Coach.class);
		
		//Call method(s) on the Bean:
		System.out.println(myCoach.getDailyWorkout());
		System.out.println(myCoach.getFortune());
		
		//Close Application Context:
		context.close();
	}

}
