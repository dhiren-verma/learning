package com.hibernate_tutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.demo.entity.Student;

public class UpdateHibernateDemo_5 {

	public static void main(String[] args) {
		//Get Session Factory:
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Get Session Instance
		Session session = factory.getCurrentSession();
		
		try {
			//Begin Transaction:
			session.beginTransaction();
			
//			//Get the Student which needs to be updated:
//			int studentId = 1;
//			
//			Student uStudent = session.get(Student.class, studentId);
//			
//			//Update Student
//			if (uStudent!=null)
//				uStudent.setFirstName("Drake");
			
//			//To Update all Students:
//			session.createQuery("update Student set email='abc@xyz.com'").executeUpdate();
			
			//To Update all custom Student:
			session.createQuery("update Student set email='sachin@test.com' where firstName='Sachin'").executeUpdate();
			
			//Commit Transaction:
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
