package com.hibernate_tutorial.one_to_many.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.one_to_many.demo.entity.Course;
import com.hibernate_tutorial.one_to_many.demo.entity.Instructor;
import com.hibernate_tutorial.one_to_many.demo.entity.InstructorDetail;

public class LazyNoErrorDemo {

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
				
				//Call Course Getter method before Transaction is committed & Session is closed:
				//Remember just calling the getter itself wont matter as it wont force Hibernate
				//to fetch associated Courses for this Instructor, only an operation that does
				//some operation on the retrieved Courses will suffice, otherwise the Courses
				//won't be retrieved:
				//This below statement wont retrieve Courses for this Instructor from DB:
//				instructor.getCourses();
				
				//Although any of the following operation will force Hibernate to retrieve
				//Courses associated with this Instructor:
				instructor.getCourses().stream().count();
//				System.out.println("Courses are: "+instructor.getCourses());
			}
			
			//Commit the Transaction:
			session.getTransaction().commit();
			
			//Close the Session also:
			session.close();
			
			//Now it wont throw LaziInitializationException,
			//as the courses were loaded when the Session was still active:
			System.out.println("Courses: "+instructor.getCourses());
		} finally {
			factory.close();
		}
	}

}
