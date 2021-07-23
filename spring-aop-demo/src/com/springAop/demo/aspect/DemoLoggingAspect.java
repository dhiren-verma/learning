package com.springAop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
	
	//Here we add all of our Related Advice for Logging:
	
	//Applies to all methods from a particular package with void(no) return type & 0 or more Arguments of any type:
//	@Before("execution(void com.springAop.demo.dao.*.*(..))")
	
	//Applies to all methods from a particular package with any return type & 0 or more Arguments of any type: 
//	@Before("execution(* com.springAop.demo.dao.*.*(..))")
	
	//Applies to all methods with the signature "public void addAccount(com.springAop.demo.entity.Account, ..)"
	//with first parameter as instance of com.springAop.demo.entity.Account & 0 or more additional parameters of any type:
	@Before("execution(public void addAccount(com.springAop.demo.entity.Account, ..))")
	
	//Applies to all methods with the signature "public void addAccount(...)" with 0 or more Arguments of any type:
//	@Before("execution(public void addAccount(..))")
	
	//Applies to all methods with the signature "public void addAccount(?)" with 1 Argument of any type:
//	@Before("execution(public void addAccount(*))")
	
	//Applies to all methods with the signature "public void addAccount(com.springAop.demo.entity.Account)" from any class:
//	@Before("execution(public void addAccount(com.springAop.demo.entity.Account))")
	
	//Applies to all methods that start with 'add' String & having signature "public void add*()" from any class:
//	@Before("execution(public void add*())")
	
	//Applies to all methods with the signature "public void addAccount()" from any class:
//	@Before("execution(public void addAccount())")
	
	//Applies to method with the signature "public void addAccount()" from DemoAccountDAO class:
//	@Before("execution(public void com.springAop.demo.dao.DemoAccountDAO.addAccount())")
	
	//Applies to method with the signature "public boolean addAccount()" from any class:
//	@Before("execution(public boolean addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("===>>>Executing @Before Advice on mentioned Method");
	}
	
}