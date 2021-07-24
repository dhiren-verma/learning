package com.hibernate_tutorial.one_to_many.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.one_to_many.demo.entity.Course;
import com.hibernate_tutorial.one_to_many.demo.entity.Instructor;
import com.hibernate_tutorial.one_to_many.demo.entity.InstructorDetail;
import com.hibernate_tutorial.one_to_many.demo.entity.Review;

public class GetCourseReviewsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		try {
			Session session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			//Get a Course from DB:
			int courseId = 1;
			Course course = session.get(Course.class, courseId);
			
			if (course!=null) {
				System.out.println("Course fetched from DB is: "+course);
				
				System.out.println("& its Reviews are: ");
				
				for (Review review : course.getReviews())
					System.out.println(review);
				
			}
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
