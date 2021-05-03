package com.hibernate_tutorial.many_to_many.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.many_to_many.demo.entity.Course;
import com.hibernate_tutorial.many_to_many.demo.entity.Instructor;
import com.hibernate_tutorial.many_to_many.demo.entity.InstructorDetail;
import com.hibernate_tutorial.many_to_many.demo.entity.Review;
import com.hibernate_tutorial.many_to_many.demo.entity.Student;

public class CreateCourseAndStudentsDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		try {
			//Get Session:
			Session session = factory.getCurrentSession();
			
			//Start Transaction:
			session.beginTransaction();
			
			//Create a Course:
			Course newCourse = new Course("Java Tutorial");
			
			//Save the Course:
			session.save(newCourse);
			
			//Create new Students:
			Student firstStudent = new Student("Ashish", "Kalra", "ashish.kalra@gmail.com");
			Student secondStudent = new Student("Sachin", "Jain", "sachin.jain@gmail.com");
			
			//Enroll New Students for the Course:
			newCourse.enrollStudent(firstStudent);
			newCourse.enrollStudent(secondStudent);
			
			//Save the Students:
			session.save(firstStudent);
			session.save(secondStudent);
			
			System.out.println("Saved Students for the Course are:\n"+newCourse.getStudents());
			
			//Commit the Transaction:
			System.out.println("Committing the Transaction:");
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
