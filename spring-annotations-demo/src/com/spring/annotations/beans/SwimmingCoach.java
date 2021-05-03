package com.spring.annotations.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.spring.annotations.interfaces.Coach;
import com.spring.annotations.interfaces.FortuneService;

@Component
public class SwimmingCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//Load Value from sport.properties file:
	@Value("${coach.email}")
	private String email;
	
	//Load Value from sport.properties file:
	@Value("${coach.team}")
	private String team;
	
	//Constructor Dependency Injection with Auto-Wiring
	@Autowired
	public SwimmingCoach(@Qualifier("rFortuneService") FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getTeam() {
		return team;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Do Butterfly-Stroke for 30 Minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}
