package com.hibernate_tutorial.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_tutorial.demo.entity.Employee;

public class HibernateCURDDemo_7 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session;
		
		try {
			//Save a few New Employees:
			List<Employee> employees = new ArrayList<>();
			
			employees.add(new Employee("Akshay", "Tyagi", "Nagarro"));
			employees.add(new Employee("Sachin", "Jain", "Qualcomm"));
			employees.add(new Employee("Shaoib", "Gauri", "IGamingSoft"));
			
			//Save Employees in DB:
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			for(Employee employee : employees)
				session.save(employee);
			
			session.getTransaction().commit();
			
			System.out.println("Employees saved to DB");
			
			
			//retrieve particular Employee from DB:
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Employee retrievedEmp = session.get(Employee.class, employees.get(0).getId());
			
			if (retrievedEmp!=null)
				System.out.println("Employee successfully retrieved which is:\n"+retrievedEmp);
			else
				System.out.println("No such Employee found in DB");
			
			//Retrieve Employee from a particular Company:
			String companyName = "Qualcomm";
			List<Employee> companyEmps = session.createQuery("from Employee e WHERE e.company='"+companyName+"'").getResultList();
			
			session.getTransaction().commit();
			
			if (companyEmps!=null && !companyEmps.isEmpty()) {
				System.out.println("Found Employees for Company: "+companyName);
				
				companyEmps.stream().forEach(emp -> {
					System.out.println(emp);
				});
			}
			
			//Delete an Employee on the basis of Primary Key:
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.delete(employees.get(employees.size()-1));
			
			session.getTransaction().commit();
			
		} catch(Exception ex) {
			System.out.println("Exception caught is: "+ex);
			ex.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
