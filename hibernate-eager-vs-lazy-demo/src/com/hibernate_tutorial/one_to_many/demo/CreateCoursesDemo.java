package com.hibernate_tutorial.one_to_many.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.one_to_many.demo.entity.Course;
import com.hibernate_tutorial.one_to_many.demo.entity.Instructor;
import com.hibernate_tutorial.one_to_many.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
				//Create Courses:
				List<Course> courses = new ArrayList<>();
				
				courses.add(new Course("Kickboxing"));
				courses.add(new Course("Grapling"));
				courses.add(new Course("Ground Impound"));
				
				
				courses.stream().forEach(course -> {
					//Associate Courses with Instructor
					instructor.addCourse(course);
					
					//Save Courses in DB:
					session.save(course);
				});
				
			}
			
			//Commit the Transaction:
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
