package com.spring.autowiring.demo;

import com.spring.demo.Coach;
import com.spring.demo.FortuneService;

public class NoAutowiringCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public NoAutowiringCoach() {
		
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return this.getClass().getSimpleName()+" says: \"Do practice a lot daily\"";
	}
	
	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}
	
}
