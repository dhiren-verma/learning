package com.spring.annotations.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.spring.annotations.interfaces.Coach;
import com.spring.annotations.interfaces.FortuneService;

@Component
@Scope("prototype")
public class FootballCoach implements Coach {
	
	//Field Dependency Injection with Auto-Wiring:
	//Java fulfills it by using Reflection:
	//NOTE: Auto-Wiring is prone to fail if there are
	//multiple Implementations available for the
	//required Dependency. In that case we can use
	//@Qualifier Annotation with Default Bean Id or
	//given Bean Id of the expected Dependency. 
	@Autowired
	@Qualifier("rFortuneService")
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Do Dribbling Practice for 30 Mins";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}