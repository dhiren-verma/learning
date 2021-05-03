package com.spring.annotations.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.spring.annotations.interfaces.Coach;
import com.spring.annotations.interfaces.FortuneService;

@Component
@Scope("singleton")
public class BaseballCoach implements Coach {
	
	//Private field for Dependency:
	private FortuneService fortuneService;
	
	//Method Dependency Injection with Auto-Wiring:
	//Method doesn't need to be a Setter Method, it
	//can be any method with @Autowired annotation:
	//NOTE: Auto-Wiring is prone to fail if there are
	//multiple Implementations available for the
	//required Dependency. In that case we can use
	//@Qualifier Annotation with Default Bean Id or
	//given Bean Id of the expected Dependency. 
	@Autowired
	@Qualifier("luckyFortuneService")
	public void doFulfillDependency(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Get 30 Minutes of Batting Practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}