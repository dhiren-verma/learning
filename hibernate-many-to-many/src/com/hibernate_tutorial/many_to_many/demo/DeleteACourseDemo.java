package com.hibernate_tutorial.many_to_many.demo;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.many_to_many.demo.entity.Course;
import com.hibernate_tutorial.many_to_many.demo.entity.Instructor;
import com.hibernate_tutorial.many_to_many.demo.entity.InstructorDetail;
import com.hibernate_tutorial.many_to_many.demo.entity.Review;
import com.hibernate_tutorial.many_to_many.demo.entity.Student;

public class DeleteACourseDemo {
	
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
			
			//Get a Course from DB:
			int courseId = 8;
			Course course = session.get(Course.class, courseId);
			
			if (course!=null) {
				//Log the retrieved Course:
				System.out.println("Course is: "+course);
				System.out.println("Students enrolled for this Course are: "+course.getStudents());
				
				//Delete the Course:
				session.delete(course);
				JOptionPane.showMessageDialog(null, "Course Deleted:");
			}
			
			//Commit the Transaction:
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
