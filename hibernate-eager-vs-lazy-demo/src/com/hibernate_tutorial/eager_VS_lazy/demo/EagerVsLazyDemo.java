package com.hibernate_tutorial.eager_VS_lazy.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.eager_VS_lazy.demo.entity.Course;
import com.hibernate_tutorial.eager_VS_lazy.demo.entity.Instructor;
import com.hibernate_tutorial.eager_VS_lazy.demo.entity.InstructorDetail;

public class EagerVsLazyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		try {
			//Get Session:
			Session session = factory.getCurrentSession();
			
			//Start Transaction:
			session.beginTransaction();
			
			//Get Instructor from DB:
			int instructorId = 1;
			
			Instructor instructor = session.get(Instructor.class, instructorId);
			
			if (instructor!=null) {
				System.out.println("Instructor: "+instructor);
				
				System.out.println("Courses: "+instructor.getCourses());
			}
			
			//Commit the Transaction:
			session.getTransaction().commit();
			
//			System.out.println("Courses: "+instructor.getCourses());
		} finally {
			factory.close();
		}
	}

}
