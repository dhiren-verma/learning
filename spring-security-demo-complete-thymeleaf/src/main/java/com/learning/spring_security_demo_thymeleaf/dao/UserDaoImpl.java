package com.learning.spring_security_demo_thymeleaf.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.spring_security_demo_thymeleaf.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	Logger logger;
	
	@PostConstruct
	private void initializeLogger() {
		logger = Logger.getLogger(getClass().getName());
	}
	
	@Override
	public User getUserByName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<User> userSearchQuery = session.createQuery("from User where userName=:username", User.class);
		
		userSearchQuery.setParameter("username", userName);
		
		User user = null;
		
		try {
			user = userSearchQuery.getSingleResult();
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "User search exception", ex);
		}
		
		return user;
	}

	@Override
	public void saveUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(user);
	}
	
}