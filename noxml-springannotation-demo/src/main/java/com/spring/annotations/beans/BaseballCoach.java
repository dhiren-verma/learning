package com.spring.annotations.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.spring.annotations.interfaces.Coach;
import com.spring.annotations.interfaces.FortuneService;

@Component("bCoach")
@Scope("prototype")
public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Autowired
	public BaseballCoach(@Qualifier("luckyFortuneService")FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public String getDailyWorkout() {
		return "Get 30 Minutes of Batting Practice";
	}
	
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}