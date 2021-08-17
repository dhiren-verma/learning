package com.learning.spring_security_demo_complete.dao;

import com.learning.spring_security_demo_complete.entity.Role;

public interface RoleDao {
	
	public Role findRoleByName(String roleName);
	
}
