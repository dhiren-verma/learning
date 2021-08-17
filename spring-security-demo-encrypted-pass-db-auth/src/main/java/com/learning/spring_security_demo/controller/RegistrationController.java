package com.learning.spring_security_demo.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.spring_security_demo.user.CrmUser;

//Added for being able to Create New User(s):
@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserDetailsManager userDetailsManager;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private Map<String, String> roles;
	
	@PostConstruct
	protected void initializeRoles() {
		roles = new LinkedHashMap<>();
		
		roles.put("ROLE_EMPLOYEE", "Employee");
		roles.put("ROLE_MANAGER", "Manager");
		roles.put("ROLE_ADMIN", "Admin");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor strTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, strTrimmerEditor);
	}
	
	@GetMapping("/showRegistrationForm")
	public String getRegistrationForm(Model userModel) {
		userModel.addAttribute("user", new CrmUser());
		userModel.addAttribute("roles", roles);
		
		return "registration-form";
	}
	
	@PostMapping("/processRegistrationForm")
	public String processRegistrationRequest(@Valid @ModelAttribute("user")CrmUser user,
			BindingResult validationResult, Model userModel) {
		if (validationResult.hasErrors()) {
			//Return with an Error on Page:
			userModel.addAttribute("user", new CrmUser());
			userModel.addAttribute("roles", roles);
			userModel.addAttribute("registrationError", "User name/password can not be empty.");
			
			logger.warning("User name/password can not be empty.");
			
			return "registration-form";
		}
		
		//Check if the User already exists:
		String userName = user.getUserName();
		
		if (userDetailsManager.userExists(userName)) {
			//User already exists:
			userModel.addAttribute("user", new CrmUser());
			userModel.addAttribute("roles", roles);
			userModel.addAttribute("registrationError", "User name already exists");
			
			logger.warning("User name already exists.");
			
			return "registration-form";
		}
		
		//Otherwise save this new User to DB:
		String enocdedPassword = "{bcrypt}"+passwordEncoder.encode(user.getPassword());
		
		//Give User default Role of Employee:
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList();
		authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
		
		//If User selected Role other than Employee, then add that Role too:
		if (!user.getFormRole().equals("Employee")) {
			authorities.add(new SimpleGrantedAuthority(user.getFormRole()));
		}
		
		//Create new User object from Spring Security framework:
		User newUser = new User(userName, enocdedPassword, authorities);
		
		//Save new User object to DB:
		userDetailsManager.createUser(newUser);
		
		return "registration-confirmation";
	}
	
}