package com.learning.spring_security_demo_complete.dao;

import com.learning.spring_security_demo_complete.entity.User;

public interface UserDao {
	
	public User findByUserName(String username);
	
	public void saveUser(User user);
	
}