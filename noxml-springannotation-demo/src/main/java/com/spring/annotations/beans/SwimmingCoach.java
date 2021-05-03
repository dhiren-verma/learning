package com.spring.annotations.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.annotations.interfaces.Coach;
import com.spring.annotations.interfaces.FortuneService;

@Component
public class SwimmingCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Autowired
	@Qualifier("rFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public String getDailyWorkout() {
		return "Do Backstroke practice for 15 Mins";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
