package com.hibernate_tutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.demo.entity.Student;

public class PrimaryKeyDemo_2 {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//Start Transaction:
			session.beginTransaction();
			
			//Create multiple Student objects:
			for (int i=0; i<3; i++) {
				Student tempStudent = new Student(String.valueOf("scienceStudent"+i), "Test", String.valueOf("scienceStudent"+i+"@test.com"), null);
				
				session.save(tempStudent);
			}
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
	
}
