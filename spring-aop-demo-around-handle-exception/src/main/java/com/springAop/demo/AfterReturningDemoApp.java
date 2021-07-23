package com.springAop.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springAop.demo.dao.DemoAccountDAO;
import com.springAop.demo.entity.Account;

public class AfterReturningDemoApp {
	
	public static void main(String[] args) {
		// Read the Spring Configuration Java Class:
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//Get the Bean from Spring Container:
		DemoAccountDAO accountDAO = context.getBean("demoAccountDAO", DemoAccountDAO.class);
		
		//Call the business method:
		List<Account> accounts = accountDAO.findAccounts(false);
		
		System.out.println("AfterReturningDemoApp: printing the fetched Accounts");
		
		accounts.stream().forEach(System.out::println);
		
		//Close the Context:
		context.close();
		
	}

}