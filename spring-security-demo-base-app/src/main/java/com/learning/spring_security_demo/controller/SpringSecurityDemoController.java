package com.learning.spring_security_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringSecurityDemoController {
	
	@GetMapping("/home")
	public String getHomePage() {
		return "home";
	}
	
	
	
}