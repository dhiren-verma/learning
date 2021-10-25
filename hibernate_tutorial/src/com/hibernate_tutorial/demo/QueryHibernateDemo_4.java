package com.hibernate_tutorial.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.demo.entity.Student;

public class QueryHibernateDemo_4 {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//Begin Transaction:
			session.beginTransaction();
			
			//Query all Object from a Table:
			List<Student> students;
			
			//Query to get all Records from Table:
			students = session.createQuery("from Student", Student.class).getResultList();
			
			//Print the Result:
			System.out.println("Students retrieved from DB are:\n");
			students.stream().forEach(student -> System.out.println(student));
			
			//Query Objects based on WHERE Clause:
			students = session.createQuery("from Student s where s.lastName='Tyagi'", Student.class).getResultList();
			
			System.out.println("Students retrieved using WHERE Clause:\n");
			students.stream().forEach(student -> System.out.println(student));
			
			//Query Objects based on OR Predicate:
			students = session.createQuery("from Student s where s.lastName='Tyagi' OR s.firstName='Sachin'", Student.class).getResultList();
			
			System.out.println("Students retrieved using OR Predicate with WHERE Clause:\n");
			students.stream().forEach(student -> System.out.println(student));
			
			//Query Objects based on LIKE Predicate:
			students = session.createQuery("from Student s WHERE s.email LIKE '%test.com'", Student.class).getResultList();
			
			System.out.println("Students retrieved using LIKE Predicate with WHERE Clause:\n");
			students.stream().forEach(student -> System.out.println(student));
			
			//Commit the Transaction:
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
	
}