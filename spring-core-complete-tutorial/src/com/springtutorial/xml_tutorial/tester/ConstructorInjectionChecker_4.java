package com.springtutorial.xml_tutorial.tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springtutorial.xml_tutorial.bean.constructorInjection.SampleOne;
import com.springtutorial.xml_tutorial.bean.constructorInjection.User;

public class ConstructorInjectionChecker_4 {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext constructorInjectionContext = new ClassPathXmlApplicationContext("com/springtutorial/xml_tutorial/bean/constructorInjection/constructorInjectionContext.xml");
		
		SampleOne obj1 = constructorInjectionContext.getBean("bean1", SampleOne.class);
		
		System.out.println("Instance is of type: "+obj1.getClass());
		
		User user = constructorInjectionContext.getBean("user", User.class);
		
		System.out.println("User's Name: "+user.getName()+
				"\nUser Id: "+user.getId());
		
		constructorInjectionContext.close();
	}
	
}
