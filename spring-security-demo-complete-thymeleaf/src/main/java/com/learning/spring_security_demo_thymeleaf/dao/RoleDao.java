package com.learning.spring_security_demo_thymeleaf.dao;

import com.learning.spring_security_demo_thymeleaf.entity.Role;

public interface RoleDao {
	
	Role getRoleByName(String roleName);
	
}
