package com.learning.spring_security_demo_thymeleaf.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.spring_security_demo_thymeleaf.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	Logger logger;
	
	@PostConstruct
	private void initializeLogger() {
		logger = Logger.getLogger(getClass().getName());
	}
	
	@Override
	public Role getRoleByName(String roleName) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Role> roleSearchQuery = session.createQuery("from Role where name=:rolename", Role.class);
		
		roleSearchQuery.setParameter("rolename", roleName);
		
		Role role = null;
		
		try {
			role = roleSearchQuery.getSingleResult();
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Role search exception", ex);
		}
		
		return role;
	}
	
}