package com.spring.annotations.beans;

import com.spring.annotations.interfaces.Coach;
import com.spring.annotations.interfaces.FortuneService;

public class BoxingCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public BoxingCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public String getDailyWorkout() {
		return "Practice Jab & Uppercut for 30 Mins";
	}
	
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public FortuneService getFortuneService() {
		return fortuneService;
	}
	
}