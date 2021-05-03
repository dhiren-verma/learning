package com.spring.demo;

public class FootballCoach implements Coach {
	
	//Private field for Dependency:
	private FortuneService fortuneService;
	
	//Constructor for Dependency Injection:
	public FootballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public void customInit() {
		System.out.println("Initializing Football Coach");
	}
	
	public void customDestroy() {
		System.out.println("Destructing Football Coach");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Do Dribbling Practice for 30 Mins";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}
	
}