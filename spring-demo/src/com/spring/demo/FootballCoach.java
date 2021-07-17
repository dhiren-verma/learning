package com.spring.demo;

//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;

public class FootballCoach implements Coach {//, InitializingBean, DisposableBean {
	
	//Private field for Dependency:
	private FortuneService fortuneService;
	
	//Constructor for Dependency Injection:
	public FootballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public void customInit() {
		System.out.println("Initializing Football Coach");
	}
	
	public void customDestroy() {
		System.out.println("Destructing Football Coach");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Do Dribbling Practice for 30 Mins";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

//	@Override
//	public void destroy() throws Exception {
//		System.out.println("Destructing Football Coach using DisposableBean destroy method");
//	}
//
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("Initializing Football Coach using InitializingBean afterPropertiesSet method");		
//	}
	
}