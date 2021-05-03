package com.spring.demo;

public class BaseballCoach implements Coach {
	
	//Private field for Dependency:
	private FortuneService fortuneService;
	
	//Constructor for Dependency Injection:
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	private void myInit() {
		System.out.println("myInit Method of BaseballCoach");
	}
	
	void myDestroy() {
		System.out.println("myDestroy Method of BaseballCoach");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Get 30 Minutes of Batting Practice";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}
	
}