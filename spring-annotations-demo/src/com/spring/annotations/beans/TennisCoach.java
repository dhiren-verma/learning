package com.spring.annotations.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.annotations.interfaces.Coach;
import com.spring.annotations.interfaces.FortuneService;

//@Component("tCoach")
@Component
public class TennisCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//Setter Dependency Injection with Auto-Wiring:
	//NOTE: Auto-Wiring is prone to fail if there are
	//multiple Implementations available for the
	//required Dependency. In that case we can use
	//@Qualifier Annotation with Default Bean Id or
	//given Bean Id of the expected Dependency. 
	@Autowired
	@Qualifier("rFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Get 30 Minutes of Service Workout";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}