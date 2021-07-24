package com.hibernate_tutorial.many_to_many.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.many_to_many.demo.entity.Course;
import com.hibernate_tutorial.many_to_many.demo.entity.Instructor;
import com.hibernate_tutorial.many_to_many.demo.entity.InstructorDetail;
import com.hibernate_tutorial.many_to_many.demo.entity.Review;
import com.hibernate_tutorial.many_to_many.demo.entity.Student;

public class GetCoursesForStudentDemo {
	
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
			
			//Get existing Student from DB:
			int studentId = 7;
			Student student = session.get(Student.class, studentId);
			
			if (student!=null) {
				//Log the retrieved Student:
				System.out.println("Student is: "+student);
				System.out.println("Courses already assigned to him are: "+student.getCourses());
			}
			
			//Commit the Transaction:
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
