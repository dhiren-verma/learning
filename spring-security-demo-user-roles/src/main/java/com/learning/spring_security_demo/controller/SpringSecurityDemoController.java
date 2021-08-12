package com.learning.spring_security_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringSecurityDemoController {
	
	@GetMapping("/")
	public String getHomePage() {
		return "home";
	}
	
	@GetMapping("/leaders")
	public String getManagerPage() {
		return "managerPage";
	}
	
	@GetMapping("/systems")
	public String getAdminPage() {
		return "adminPage";
	}
	
}