package com.spring.autowiring.demo;

import com.spring.demo.Coach;
import com.spring.demo.FortuneService;

public class ConstructorAutowiringCoach implements Coach {
	
	private final FortuneService fortuneService;
	
	public ConstructorAutowiringCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return this.getClass().getSimpleName()+" says: \"Have a good day\"";
	}
	
	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}
	
}
