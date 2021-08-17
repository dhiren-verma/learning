package com.learning.spring_security_demo_complete.dao;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.spring_security_demo_complete.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Role findRoleByName(String roleName) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Role> roleSearchQuery = currentSession.createQuery("from Role where name=:roleName", Role.class);
		
		roleSearchQuery.setParameter("roleName", roleName);
		
		Role role = null;
		
		try {
			role = roleSearchQuery.getSingleResult();
		} catch (Exception ex) {
			
		}
		
		return role;
	}
	
}