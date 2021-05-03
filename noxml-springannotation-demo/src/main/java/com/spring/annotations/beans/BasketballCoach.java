package com.spring.annotations.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.spring.annotations.interfaces.Coach;
import com.spring.annotations.interfaces.FortuneService;

@Component
public class BasketballCoach implements Coach {
	
	@Autowired
	@Qualifier("rFortuneService")
	private FortuneService fortuneService;
	
	@Value("${coach.email}")
	private String email;
	
	@Value("${coach.team}")
	private String team;
	
	public String getDailyWorkout() {
		return "Do dribbling practice for 30 Mins";
	}
	
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getTeam() {
		return team;
	}
	
}
