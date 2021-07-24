package com.hibernate_tutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.demo.entity.Student;

public class ReadStudentDemo_3 {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		try {
			//Create a Student to save to DB:
			Student tempStudent = new Student("Sachin", "Jain", "sachin@test.com", null);
			
			//Begin Transaction:
			session.beginTransaction();
			
			//Save Student to DB:
			session.save(tempStudent);
			
			//Commit the Transaction:
			session.getTransaction().commit();
			
			//As the Transaction has been saved, therefore our Student which we tried to save must contains Primary Key Id:
			System.out.println(tempStudent.getId());
			
			//Now lets try to retrieve the Saved Student from DB, based on Id:
			//Begin Transaction:
			session.beginTransaction();
			
			//Retrieve Saved Object:
			Student retrievedStudent = session.get(Student.class, tempStudent.getId());
			
			//Commit the Transaction:
			session.getTransaction().commit();
			
			
			if (retrievedStudent!=null) {
				System.out.println("Retrieved Object is: "+retrievedStudent);
			} else {
				System.out.println("Object couldn't be retrieved");
			}
			
		} finally {
			factory.close();
		}
		
	}

}
