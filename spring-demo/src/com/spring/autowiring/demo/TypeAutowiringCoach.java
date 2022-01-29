package com.spring.autowiring.demo;

import com.spring.demo.Coach;
import com.spring.demo.FortuneService;

public class TypeAutowiringCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TypeAutowiringCoach() {
		
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return this.getClass().getSimpleName()+" says: \"Perfection always pays\"";
	}
	
	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}
	
}
