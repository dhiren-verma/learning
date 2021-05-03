package com.spring.demo;

public class TrackCoach implements Coach {
	
	//Private field for Dependency:
	private FortuneService fortuneService;
	
	//Constructor for Dependency Injection:
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run 5000 metre";
	}
	
	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}
	
}