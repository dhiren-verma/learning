package com.hibernate_tutorial.one_to_one.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.one_to_one.demo.entity.Instructor;
import com.hibernate_tutorial.one_to_one.demo.entity.InstructorDetail;

public class DeleteOneToOneDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();
		
		try {
			
			//Get Session:
			Session session = factory.getCurrentSession();
			
			//Start Transaction:
			session.beginTransaction();
			
			//Get Instructor by Primary Key/ID:\
			Instructor tBDInstructor = session.get(Instructor.class, 2);
			
			//Delete that Instructor:
			//It will also delete entry from both instructor & instructor_detail table, as CascadeType.ALL is selected:
			if (tBDInstructor!=null) {
				System.out.println("Instructor to be deleted is: "+tBDInstructor);
				session.delete(tBDInstructor);
			}
			
			//Commit the Transaction:
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
