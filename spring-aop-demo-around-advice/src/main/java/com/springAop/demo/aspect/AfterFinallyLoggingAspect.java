package com.springAop.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterFinallyLoggingAspect {
	
	@After("execution(* com.springAop.demo.dao.DemoAccountDAO.findAccounts(..))")
	public void afterFindAccountFinallyAdvice(JoinPoint theJoinPoint) {
		//Read Method Signature:
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println(methodSignature);
		
		System.out.println("AfterFinallyLoggingAdvice: after calling findAccounts:");
		
	}
	
}
