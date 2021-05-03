package com.demo.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Just a Hello World Spring MVC Demo
 * 
 * @author Vermas-Dell
 */
@Controller
public class DemoController1 {
	
	@RequestMapping("/")
	public String getViewName() {
		return "hello-spring-mvc";
	}
	
}
