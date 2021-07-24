package com.hibernate_tutorial.one_to_many.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.one_to_many.demo.entity.Course;
import com.hibernate_tutorial.one_to_many.demo.entity.Instructor;
import com.hibernate_tutorial.one_to_many.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		try {
			//Create Instructor:
			Instructor instructor = new Instructor("Nathan", "Diaz", "ufc.nathandiaz@gmail.com");
			
			//Create Instructor Detail:
			InstructorDetail instructorDetail = new InstructorDetail("https://ufc.nathandiaz/youtube", "MMA");
			
			//Associate the Instructor & Instructor Detail:
			instructor.setInstructorDetail(instructorDetail);
			
			//Get Session:
			Session session = factory.getCurrentSession();
			
			//Start Transaction:
			session.beginTransaction();
			
			//Save the Object(s) in DB:
			session.save(instructor);
			
			//Commit the Transaction:
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
