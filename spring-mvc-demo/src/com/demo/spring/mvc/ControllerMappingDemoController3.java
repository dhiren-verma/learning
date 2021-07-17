package com.demo.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller Request Mapping Demo
 * 
 * @author Vermas-Dell
 */
@Controller
@RequestMapping("/new")
public class ControllerMappingDemoController3 {
	
	@RequestMapping("/showForm")
	public String registrationForm() {
		return "new-registration-form";
	}
	
	@RequestMapping("/processRegistration")
	public String processRegisttarion(@RequestParam("userName") String userName, Model model) {
		StringBuilder msg = new StringBuilder("Hi! ");
		
		msg.append(userName.toUpperCase());
		msg.append(" Wassup!");
		
		model.addAttribute("message", msg.toString());
		
		return "new-registration-successful";
	}
	
}