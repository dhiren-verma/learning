package com.springAop.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterThrowingLoggingAspect {
	
	@AfterThrowing(pointcut="execution(* com.springAop.demo.dao.DemoAccountDAO.findAccounts(..))",
			throwing="theException")
	public void afterReturingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theException) {
		//Read Method Signature:
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println(methodSignature);
		
		System.out.println("AfterThrowingLoggingAdvice: after Exception is Thrown from findAccounts:");
		 
		System.out.println("Exception is: "+theException);
		
	}
	
}