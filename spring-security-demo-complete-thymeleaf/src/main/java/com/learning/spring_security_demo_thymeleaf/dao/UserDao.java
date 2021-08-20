package com.learning.spring_security_demo_thymeleaf.dao;

import com.learning.spring_security_demo_thymeleaf.entity.User;

public interface UserDao {
	
	User getUserByName(String userName);
	
	void saveUser(User user);
	
}