package com.learning.spring_boot_demo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	
	//Injecting Properties loaded from application.properties file
	//as Value for field:
	@Value("${coach.name}")
	private String coachName;
	
	//Injecting Properties loaded from application.properties file
	//as Value for field:
	@Value("${team.name}")
	private String teamName;
	
	//One thing to notice is that here we are not using any other method other than Get,
	//So its only natural to block all other methods:
	//This can be done by using Spring Interceptors, which can intercept HTTP Requests
	//for an application an perform pre-processing and post-processing:
	//For this we will create an interceptor that will pre-process HTTP requests,
	//if the request doesn't match our approved HTTP method, then we will reject the requests.
	
	@GetMapping("/")
	public String welcomeMsg() {
		return "Hello World! Time on Server is: "+LocalDateTime.now();
	}
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach: "+coachName+", Team Name: "+teamName;
	}
	
	@GetMapping("/workout")
	public String getWorkoutMsg() {
		return "Run a hard 5k!";
	}
	
	@GetMapping("/fortune")
	public String getFortune() {
		return "Today is your Lucky Day!";
	} 
	
}
