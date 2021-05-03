package com.hibernate_tutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.demo.entity.Student;

public class DeleteHibernateDemo_6 {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Get Session:
		Session session = factory.getCurrentSession();
		
		//Begin Transaction:
		session.beginTransaction();
		
		//Approach 1:
		//Get Student whom we want to Delete:
		int studentId = 2;
		
		Student dStudent = session.get(Student.class, studentId);
		
		//If there is any such Student found, then Delete him:
		if (dStudent!=null)
			session.delete(dStudent);
		
		//Approach 2:
		//We don't need to get the Student whom we want to delete,
		//We will do it with Hibernate Query itself:
		studentId = 3;
		session.createQuery("delete from Student where id="+studentId).executeUpdate();
		
		//Commit Transaction:
		session.getTransaction().commit();
		
	}

}
