package com.spring.annotations.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.annotations.interfaces.Coach;
import com.spring.annotations.interfaces.FortuneService;

@Component
public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Autowired
	@Qualifier("luckyFortuneService")
	public void initializeFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@PostConstruct
	public void doPostInitProcessing() {
		System.out.println("Finalizing Bean Post Initlialization Process for CricketCoach:");
	}
	
	@PreDestroy
	public void doPreDestroyProcessing() {
		System.out.println("Finishing Pre Destruction Tasks  for CricketCoach:");
	}
	
	public String getDailyWorkout() {
		return "Do Bowling Practice for 30 Mins";
	}
	
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
