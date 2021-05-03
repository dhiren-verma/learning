package com.hibernate_tutorial.one_to_one.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.one_to_one.demo.entity.Instructor;
import com.hibernate_tutorial.one_to_one.demo.entity.InstructorDetail;

public class BiDirectionalSelectDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();
		
		try {
			Session session = factory.getCurrentSession();
			
			int instructorDetailId = 2;
			
			session.beginTransaction();
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);
			
			System.out.println("Instructor Detail fetched is: "+instructorDetail);
			
			System.out.println("Instructor retrieved using Bi-Directional Relations from Instructor Detail is:\n"+instructorDetail.getInstructor());
			
			session.getTransaction().commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
