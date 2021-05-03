package com.hibernate_tutorial.one_to_one.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.one_to_one.demo.entity.Instructor;
import com.hibernate_tutorial.one_to_one.demo.entity.InstructorDetail;

public class BiDirectionalDeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		try {
			int instructorDetailId = 2;
			
			Session session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);
			
			if (instructorDetail!=null) {
				session.delete(instructorDetail);
			}
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
