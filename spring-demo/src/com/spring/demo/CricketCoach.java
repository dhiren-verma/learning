package com.spring.demo;

import org.springframework.beans.factory.DisposableBean;

//This is registered as a Prototype Bean in BeanLifeCycle-ApplicationContext.xml
//Hence its Destruction wont be handled by Spring Container
//To sort this we can Use Custom Bean Processor(MyPrototypeBeanProcessor) in this
//case to handle its Destruction when the Spring Container is closed. 
public class CricketCoach implements Coach, DisposableBean {
	
	//Private field for Dependency:
	public FortuneService cricketFortuneService;
	
	//Constructor for Dependency Injection:
	public CricketCoach(FortuneService fortuneService) {
		cricketFortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Do Fielding Practice for 30 Minutes\n"
				+ "then after a rest of 20 Minutes\n"
				+ "do Batting Practice for 30 Minutes more";
	}
	
	@Override
	public String getFortune() {
		return cricketFortuneService.getFortune();
	}
	
	public void customInit() {
		System.out.println("Initializing Cricket Coach");
	}
	
	public void customDestroy() {
		System.out.println("Destructing Cricket Coach");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Calling CricketCoach destroy() method inherited from DisposableBean\n"
				+ "with the help of Custom Prototype Bean Processor");
	}
	
}