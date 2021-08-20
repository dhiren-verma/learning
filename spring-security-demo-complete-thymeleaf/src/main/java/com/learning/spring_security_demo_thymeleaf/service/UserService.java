package com.learning.spring_security_demo_thymeleaf.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.learning.spring_security_demo_thymeleaf.entity.User;
import com.learning.spring_security_demo_thymeleaf.user.CrmUser;

public interface UserService extends UserDetailsService {
	
	User findUserByName(String userName);
	
	void saveUser(CrmUser crmUser);
	
}