package com.learning.spring_boot_demo.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	
	@GetMapping("/")
	public String welcomeMsg() {
		return "Hello World! Time on Server is: "+LocalDateTime.now();
	}
	
}
