package com.hibernate_tutorial.one_to_one.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.one_to_one.demo.entity.Instructor;
import com.hibernate_tutorial.one_to_one.demo.entity.InstructorDetail;

public class CreateOneToOneDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();
		
		try {
			//Create the Objects:
//			Instructor instructor = new Instructor("Nathan", "Diaz", "ufc.nathandiaz@gmail.com");
//			
//			InstructorDetail instructorDetail = new InstructorDetail("https://ufc.nathandiaz/youtube", "MMA");
//			
//			//Associate the Objects:
//			instructor.setInstructorDetail(instructorDetail);
			
			//Create Second Instance of the Objects, just for them to be deleted using the Delete Demo:
			Instructor instructor = new Instructor("Jason", "Hunt", "jason.hunt@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("https://jason.hunt/youtube", "Acting");
			
			//Associate the Objects:
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
