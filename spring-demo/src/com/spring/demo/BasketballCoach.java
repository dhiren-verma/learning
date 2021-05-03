package com.spring.demo;

/**
 * Class to illustrate Setter Injection
 * 
 * @author Dhirendra
 */
public class BasketballCoach implements Coach {
	
	private FortuneService fortuneService;
	private String email;
	private String team;
	
	protected void bInit() {
		System.out.println("bInit Method of BasketballCoach");
	}
	
	protected void bDestroy() {
		System.out.println("bDestroy Method of BasketballCoach");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	} 
	
	public String getTeam() {
		return team;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Do ten 3 Pointers";
	}
	
	@Override
	public String getFortune() {
		return fortuneService!=null?fortuneService.getFortune():"!";
	}
	
}