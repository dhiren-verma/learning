package com.learning.webCustomerTracker_AllJavaConfig.aspect;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	//Setup Logger:
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//Setup Pointcut Expressions:
	@Pointcut("execution(* com.customerTracker.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.customerTracker.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.customerTracker.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	
	//Add @Before Advice:
	@Before("forAppFlow()")
	private void before(JoinPoint theJoinPoint) {
		//Log the Method Signature being called:
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		logger.info("==>>in @Before, calling Method: "+methodSig.toShortString());
		
		//Log the Input Arguments to the Method:
		Object[] args = theJoinPoint.getArgs();
		
		if (args!=null) {
			logger.info("==>>Input Arguments are: ");
			Arrays.stream(args)
				.filter(arg -> arg!=null)
				.forEach(arg -> logger.info("==>>Argument: "+arg.toString()));
		}
		
	}
	
	//Add @AfterReturning Advice:
	@AfterReturning(pointcut="forAppFlow()",
			returning="theResult")
	private void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		//Log the Method signature which was called:
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		logger.info("==>>in @AfterReturning, from Method: "+methodSig.toShortString());
		
		//Log the Output Arguments from the Method:
		logger.info("==>>Output Result: " + theResult);
	}
	
}