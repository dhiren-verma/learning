package com.hibernate_tutorial.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.demo.entity.Student;
import com.hibernate_tutorial.demo.util.parser.DateTimeUtil;

public class CreateStudentDemo_1 {

	public static void main(String[] args) {
		//If the "hibernate.cfg.xml" resides in default directory,
		//i.e. under "src" directory, then we don't need to mention it name in .configure("") method,
		//can just leave it .configure() & Hibernate will by default look under "src" directory for
		//the "hibernate.cfg.xml" file:
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//Create a Student object:
			String dOBStr = "17/01/2991";
			
			Date dob = DateTimeUtil.parseDate(dOBStr);
			
			Student student = new Student("Akshay", "Tyagi", "akshay@test.com", dob);
			
			//start a Transaction:
			session.beginTransaction();
			
			//Save the Student object:
			//This will also save associated Object to DB, as CascadeType.ALL is used:
			session.save(student);
			
			//Commit transaction:
			session.getTransaction().commit();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
