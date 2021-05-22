package com.spring.demo;

public class CricketCoach implements Coach {
	
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

}