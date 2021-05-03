package com.hibernate_tutorial.one_to_many.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.one_to_many.demo.entity.Course;
import com.hibernate_tutorial.one_to_many.demo.entity.Instructor;
import com.hibernate_tutorial.one_to_many.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

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
			
			//Get Course by Primary Key/ID:
			int courseId = 3;
			Course tBDCourse = session.get(Course.class, courseId);
			
			//Delete that Course:
			//It should not delete the associated Instructor:
			if (tBDCourse!=null) {
				System.out.println("Course to be deleted is: "+tBDCourse);
				session.delete(tBDCourse);
			}
			
			//Commit the Transaction:
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
