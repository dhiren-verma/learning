package com.hibernate_tutorial.eager_VS_lazy.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate_tutorial.eager_VS_lazy.demo.entity.Course;
import com.hibernate_tutorial.eager_VS_lazy.demo.entity.Instructor;
import com.hibernate_tutorial.eager_VS_lazy.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			//Using HQL Query:
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+ "WHERE i.id=:theInstructorId", Instructor.class);
			
			//Set parameter on Query:
			query.setParameter("theInstructorId", instructorId);
			
			//Execute query get Result:
			//It will fetch both Instructor & associated Courses all at once, just like Eager Loading:  
			Instructor instructor = query.getSingleResult();
			
			if (instructor!=null)
				System.out.println("Instructor: "+instructor);
			
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
