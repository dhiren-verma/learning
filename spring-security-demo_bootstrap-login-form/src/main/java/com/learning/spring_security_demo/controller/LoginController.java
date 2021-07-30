package com.learning.spring_security_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/showLoginPage")
	public String getLoginForm() {
//		return "login-page";
		return "fancy-login";
	}
	
}