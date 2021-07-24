package com.hibernate_tutorial.one_to_many.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.one_to_many.demo.entity.Course;
import com.hibernate_tutorial.one_to_many.demo.entity.Instructor;
import com.hibernate_tutorial.one_to_many.demo.entity.InstructorDetail;
import com.hibernate_tutorial.one_to_many.demo.entity.Review;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		try {
			//Get Session:
			Session session = factory.getCurrentSession();
			
			//Start Transaction:
			session.beginTransaction();
			
			//Create a Course:
			Course course = new Course("Java Tutorial");
			
			//Add some Reviews:
			course.addReview(new Review("Good Tutorial, recommended!!!"));
			course.addReview(new Review("Nice Tutorial!!!"));
			course.addReview(new Review("Didn't like it"));
			
			//Save the Course:
			//This will also cascade all the associated Reviews in DB:
			session.save(course);
			
			//Commit the Transaction:
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
