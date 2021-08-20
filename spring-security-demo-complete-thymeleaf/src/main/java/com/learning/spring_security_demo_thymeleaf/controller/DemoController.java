package com.learning.spring_security_demo_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String getHomePage() {
		return "home";
	}
	
	@GetMapping("/leaders")
	public String getManagerHomePage() {
		return "managerPage";
	}
	
	@GetMapping("/systems")
	public String getAdminHomePage() {
		return "adminPage";
	}
	
}