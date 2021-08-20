package com.learning.webCustomerTracker_AllJavaConfig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/showLoginPage")
	public String getLoginPage() {
		return "login";
	}
	
	@GetMapping("/access-denied")
	public String getAccessDenied() {
		return "access-denied";
	}
	
}