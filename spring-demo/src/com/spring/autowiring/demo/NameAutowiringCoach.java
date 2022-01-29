package com.spring.autowiring.demo;

import com.spring.demo.Coach;
import com.spring.demo.FortuneService;

public class NameAutowiringCoach implements Coach {

	private FortuneService myFortuneService;
	
	public NameAutowiringCoach() {
		
	}
	
	public void setMyFortuneService(FortuneService myFortuneService) {
		this.myFortuneService = myFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return this.getClass().getSimpleName()+" says: \"Practice makes a man perfect\"";
	}
	
	@Override
	public String getFortune() {
		return myFortuneService.getFortune();
	}
	
}
