package com.learning.spring_security_demo_thymeleaf.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import com.learning.spring_security_demo_thymeleaf.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.spring_security_demo_thymeleaf.service.UserService;
import com.learning.spring_security_demo_thymeleaf.user.CrmUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	private Map<String, String> roles;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@PostConstruct
	private void initializeRoles() {
		roles = new LinkedHashMap<>();
		
		roles.put("ROLE_EMPLOYEE", "Employee");
		roles.put("ROLE_MANAGER", "Manager");
		roles.put("ROLE_ADMIN", "Admin");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/showRegistrationForm")
	public String getRegistrationPage(Model userModel) {
		userModel.addAttribute("crmUser", new CrmUser());
		userModel.addAttribute("roles", roles);
		
		return "registration-form";
	}
	
	@PostMapping("/processRegistrationForm")
	public String processRegistrationRequest(@Valid @ModelAttribute("crmUser")CrmUser user,
			BindingResult validationResult, Model userModel) {
		if (validationResult.hasErrors()) {
			logger.warning("Field Data Validation Failed");
			
			logger.warning(validationResult.toString());
			
			userModel.addAttribute("crmUser", new CrmUser());
			userModel.addAttribute("roles", roles);
			userModel.addAttribute("registrationError", "Invalid Data in fields!");
			
			return "registration-form"; 
		}
		
		User existingUser = userService.findUserByName(user.getUserName());
		
		if (existingUser!=null) {
			logger.warning("UserName already exists");
			
			userModel.addAttribute("crmUser", new CrmUser());
			userModel.addAttribute("roles", roles);
			userModel.addAttribute("registrationError", "User name already exists!");
			
			return "registration-form";
		}
		
		userService.saveUser(user);
		
		logger.info("Successfully created new User: "+user.getUserName());
		
		return "registration-confirmation";
	}
	
}