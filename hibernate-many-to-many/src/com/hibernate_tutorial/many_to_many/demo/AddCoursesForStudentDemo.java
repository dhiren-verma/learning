package com.hibernate_tutorial.many_to_many.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.many_to_many.demo.entity.Course;
import com.hibernate_tutorial.many_to_many.demo.entity.Instructor;
import com.hibernate_tutorial.many_to_many.demo.entity.InstructorDetail;
import com.hibernate_tutorial.many_to_many.demo.entity.Review;
import com.hibernate_tutorial.many_to_many.demo.entity.Student;

public class AddCoursesForStudentDemo {
	
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
				
				//Create a few new Courses:
				Course newCourse1 = new Course("MySql Tutorial");
				Course newCourse2 = new Course("React-JS Tutorial");
				
				//Enroll existing Student to these new Courses:
				newCourse1.enrollStudent(student);
				newCourse2.enrollStudent(student);
				
				//Save new Courses to DB:
				System.out.println("Saving new Courses to DB:");
				session.save(newCourse1);
				session.save(newCourse2);
				System.out.println("New Courses saved to DB.");
				
			}
			
			//Commit the Transaction:
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
