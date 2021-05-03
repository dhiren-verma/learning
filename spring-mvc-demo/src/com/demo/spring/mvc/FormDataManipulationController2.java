package com.demo.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Spring-MVC Form Data Manipulation Demo
 * 
 * @author Vermas-Dell
 */
@Controller
public class FormDataManipulationController2 {
	
	@RequestMapping("/showForm")
	public String getForm() {
		return "registration-form";
	}
	
	@RequestMapping("/showFormV2")
	public String getV2Form() {
		return "registration-formV2";
	}  
	
	@RequestMapping("/showFormV3")
	public String getV3Form() {
		return "registration-formV3";
	} 
	
	@RequestMapping("/processForm")
	public String showProcessedForm() {
		return "registration-successful";
	}
	
	@RequestMapping("/processFormV2")
	public String showProcessedFormV2(HttpServletRequest request, Model model) {
		//Read the Request Parameter from the HTML Form:
		String userName = request.getParameter("userName");
		
		//Process the Data:
		userName = userName.toUpperCase();
		
		//Create Custom Message:
		StringBuilder message = new StringBuilder("Hello! ");
		message.append(userName);
		
		//Add Message to the Model:
		model.addAttribute("message", message.toString());
		
		return "registration-successfulV2";
	}
	
	@RequestMapping("/registerV3")
	public String processRegistrationV3(@RequestParam("userName")String name, Model model) {
		StringBuilder strBldr = new StringBuilder("Hello! ");
		
		strBldr.append(name.toUpperCase());
		
		model.addAttribute("message", strBldr.toString());
		
		return "registration-successfulV3";
	}
	
}
