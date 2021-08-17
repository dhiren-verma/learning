package com.learning.spring_security_demo_complete.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

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

import com.learning.spring_security_demo_complete.entity.User;
import com.learning.spring_security_demo_complete.service.UserService;
import com.learning.spring_security_demo_complete.user.CrmUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private Map<String, String> roles;
	
	@PostConstruct
	protected void loadRoles() {
		roles = new LinkedHashMap<>();
		
		roles.put("ROLE_EMPLOYEE", "Employee");
		roles.put("ROLE_MANAGER", "Manager");
		roles.put("ROLE_ADMIN", "Admin");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, editor);
	}
	
	@GetMapping("/showRegistrationForm")
	public String getRegistrationPage(Model userModel) {
		userModel.addAttribute("crmUser", new CrmUser());
		userModel.addAttribute("roles", roles);
		
		return "registration-form";
	}
	
	@PostMapping("/processRegistrationForm")
	public String processRegistration(@Valid @ModelAttribute("crmUser") CrmUser crmUser,
			BindingResult validationResult, Model userModel) {
		String userName = crmUser.getUserName();
		
		//Form Validation:
		if (validationResult.hasErrors()) {
			logger.warning("Vaidation Errors are found!");
			
			userModel.addAttribute("crmUser", new CrmUser());
			userModel.addAttribute("roles", roles);
			
			return "registration-form";
		}
		
		//Check the DB if User already exists:
		User existing = userService.findByUserName(userName);
		
		if (existing!=null) {
			userModel.addAttribute("crmUser", new CrmUser());
			userModel.addAttribute("roles", roles);
			userModel.addAttribute("registrationError", "User name already exists!");
			
			logger.warning("User name already exists!");
			
			return "registratiomn-form";
		}
		
		//Create User Account:
		userService.save(crmUser);
		
		logger.info("Successfully created User: "+userName);
		
		return "registration-confirmation";
	}
	
}