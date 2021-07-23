package com.springAop.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springAop.demo.dao.DemoAccountDAO;
import com.springAop.demo.entity.Account;

public class AfterThrowingDemoApp {
	
	public static void main(String[] args) {
		// Read the Spring Configuration Java Class:
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//Get the Bean from Spring Container:
		DemoAccountDAO accountDAO = context.getBean("demoAccountDAO", DemoAccountDAO.class);
		
		//Call the business method:
		List<Account> accounts = null;
		
		try {
			boolean throwException = true;
			accounts = accountDAO.findAccounts(throwException);
		} catch (Exception ex) {
			System.out.println("AfterThrowingDemoApp: caught Exception:");
			ex.printStackTrace();
		}
		
		System.out.println("AfterThrowingDemoApp: printing the fetched Accounts");
		
		if (accounts!=null)
			accounts.stream().forEach(System.out::println);
		else
			System.out.println("No Account data available");
		
		//Close the Context:
		context.close();
		
	}

}