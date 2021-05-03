package com.demo.spring.mvc;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.spring.mvc.beans.Student;

/**
 * Spring MVC Form Tags & Data Binding Demo
 * 
 * @author Vermas-Dell
 */
@Controller
@RequestMapping("/student")
public class StudentController4 {
	
	//Getting Data from a Properties File
	@Value("#{standardOptionsProp}")
	private LinkedHashMap<String, String> standardOptions;
	
	@RequestMapping("/signupForm")
	public String showSignupForm(Model stuModel) {
		stuModel.addAttribute("student", new Student());
		stuModel.addAttribute("standardOpts", standardOptions);
		
		return "student-signup-form";
	}
	
	@RequestMapping("/processSignup")
	public String processSignupRequest(@ModelAttribute("student")Student student, Model stuModel) {
		System.out.println(student);
		
		StringBuilder message = new StringBuilder("Hello! ");
		
		message.append(student.toString());
		message.append("<br>");
		message.append("You've successfully signed up, Congratulations!");
		
		stuModel.addAttribute("message", message.toString());
		
		return "signup-confirmation-form";
	}
	
}
