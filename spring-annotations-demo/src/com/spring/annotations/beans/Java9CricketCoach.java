package com.spring.annotations.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.annotations.interfaces.Coach;
import com.spring.annotations.interfaces.FortuneService;

@Component
public class Java9CricketCoach implements Coach, InitializingBean, DisposableBean {
	
	private FortuneService fortuneService;
	
	//Constructor Dependency Injection with Auto-Wiring
	@Autowired
	public Java9CricketCoach(@Qualifier("luckyFortuneService")FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		
		System.out.println("Java9CricketCoach has been initialized");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Doing Post Initialization Processing for Java9CricketCoach");
		doPostInitProcessing();
	}
	
	private void doPostInitProcessing() {
		System.out.println("Post Initialization Processing done for Java9CricketCoach");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Doing Pre Destriction Processing for Java9CricketCoach");
		doPreDestructionProcessing();
		
	}
	
	private void doPreDestructionProcessing() {
		System.out.println("Pre Destruction Processing done for Java9CricketCoach");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Do Bowling Practive for 30 Mins in the nets";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}