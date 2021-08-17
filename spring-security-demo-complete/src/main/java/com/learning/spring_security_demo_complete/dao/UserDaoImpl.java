package com.learning.spring_security_demo_complete.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.spring_security_demo_complete.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User findByUserName(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<User> userSearchQuery = currentSession.createQuery("from User where userName=:theUserName", User.class);
		
		userSearchQuery.setParameter("theUserName", username);
		
		User user = null;
		
		try {
			user = userSearchQuery.getSingleResult();
		} catch (Exception ex) {
			
		}
		
		return user;
	}
	
	@Override
	public void saveUser(User user) {
		Session currentSession  = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(user);
	}
	
}