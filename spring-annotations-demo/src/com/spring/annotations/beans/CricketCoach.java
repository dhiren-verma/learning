package com.spring.annotations.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.annotations.interfaces.Coach;
import com.spring.annotations.interfaces.FortuneService;

@Component
public class CricketCoach implements Coach {
	
	//Field Dependency Injection with Auto-Wiring
	@Autowired
	@Qualifier("luckyFortuneService")
	private FortuneService fortuneService;
	
	//Life-cycle Method for Spring Bean:
	//This Annotation is removed from Java SE Binary starting from Java 9.
	//For these methods to work in Java 9 & beyond, must have javax.annotation.api.jar in Referenced
	//Libraries.   
	//To solve in that case import  "javax.annotation-api.jar"
	//This Method will execute after Constructor & injection of Dependencies
	//Access Modifier:	The method can have any access modifier (public, protected, private)
	//Return type:		The method can have any return type. However, "void' is most commonly used.
	//					If you give a return type just note that you will not be able to capture
	//					the return value. As a result, "void" is commonly used.
	//Method name:		The method can have any method name.
	//Arguments:		The method can not accept any arguments. The method should be no-arg.
	@PostConstruct
	private void doPostInitializationTasks() {
		System.out.println("Completed Post Initialization Tasks for CricketCoach");
	}
	
	//Life-cycle Method for Spring Bean:
	//This Annotation is removed from Java SE Binary starting from Java 9.
	//For these methods to work in Java 9 & beyond, must have javax.annotation.api.jar in Referenced
	//Libraries.
	//This method will execute before this Bean is destroyed
	//Access Modifier:	The method can have any access modifier (public, protected, private)
	//Return type:		The method can have any return type. However, "void' is most commonly used.
	//					If you give a return type just note that you will not be able to capture
	//					the return value. As a result, "void" is commonly used.
	//Method name:		The method can have any method name.
	//Arguments:		The method can not accept any arguments. The method should be no-arg.
	//
	//NOTE: This method wont work for Prototype Bean, as in that case once Spring Container hands
	//		over the Bean to Client, it doesn't manage that Bean anymore, hence if any Clean Up is
	//		required that must be handled by Client itself. 
	@PreDestroy
	public void doPreDestructionTasks() {
		System.out.println("Completed Pre Destruction Tasks for CricketCoach");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Do Batting practice for 30 Mins in Nets";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}
