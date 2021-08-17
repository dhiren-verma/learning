package com.learning.spring_security_demo_complete.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.learning.spring_security_demo_complete.entity.User;
import com.learning.spring_security_demo_complete.user.CrmUser;

public interface UserService extends UserDetailsService {
	
	User findByUserName(String username);
	
	void save(CrmUser crmUser);
	
}