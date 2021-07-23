package com.springAop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springAop.demo.dao.DemoAccountDAO;
import com.springAop.demo.dao.DemoMembershipDAO;
import com.springAop.demo.entity.Account;

public class MainDemoApp {
	
	public static void main(String[] args) {
		// Read the Spring Configuration Java Class:
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext(DemoConfig.class);
		
		Account newMemberAcc = new Account(1001, "Karan");
		
		
		//Get the Bean from Spring Container:
		DemoAccountDAO accountDAO = context.getBean("demoAccountDAO", DemoAccountDAO.class);
		DemoMembershipDAO membershipDAO = context.getBean("demoMembershipDAO", DemoMembershipDAO.class);
		
		//Call the business method:
		accountDAO.addAccount();
		
		accountDAO.addAccount(1);
		
		accountDAO.setName("Subhi");
		accountDAO.setServiceCode("xyz123");
		
		String name = accountDAO.getName();
		String serviceCode = accountDAO.getServiceCode();
		
		membershipDAO.addAccount();
		
		membershipDAO.addAccount(newMemberAcc);
		
		membershipDAO.addAccount(newMemberAcc, true);
		
		//Close the Context:
		context.close();
		
	}

}