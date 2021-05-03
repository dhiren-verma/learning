package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// load the Spring Container file:
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanScope-ApplicationContext.xml");
		
		// retrieve bean from Spring Container:
		Coach myCoach = context.getBean("coach", Coach.class);
		
		Coach secondCoach = context.getBean("coach", Coach.class);
		
		//Check if both the Beans are Same:
		boolean sameBean = (myCoach==secondCoach);
		
		//Print the Results:
		System.out.println("Are the Bean Singleton?\n"+sameBean);
		
		System.out.println("Memory Location of First Coach Bean is: "+myCoach);
		
		System.out.println("Memory Location of Second Coach Bean is: "+secondCoach);
		
		//Close Spring Container:
		context.close();
	}

}
