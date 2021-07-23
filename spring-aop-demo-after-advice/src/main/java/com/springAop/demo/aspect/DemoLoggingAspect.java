package com.springAop.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springAop.demo.entity.Account;

@Aspect
@Component
@Order(1)
public class DemoLoggingAspect {
	
	//Using Declared Pointcut:
//	@Before("com.springAop.demo.aspect.AopDeclarations.forDaoPackage()")
//	@Before("com.springAop.demo.aspect.AopDeclarations.forDaoPackageGetters()")
//	@Before("com.springAop.demo.aspect.AopDeclarations.forDaoPackageSetters()")
	@Before("com.springAop.demo.aspect.AopDeclarations.forDaoPackageNoGetterSetter()")
	public void beforeDaoPackageMethodAdvice(JoinPoint theJoinPoint) {
		System.out.println("===>>>Executing @Before Advice for called Method:");
		
		//Read Method Signature:
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		//Read Method Arguments:
		Object[] args = theJoinPoint.getArgs();
		
		//Print Method Signature:
		System.out.println(methodSignature);
		
		//Loop Through Method Arguments & Print them:
		for (Object arg : args) {
			if (arg instanceof Account) {
				Account acc = (Account) arg;
				
				System.out.println("Account Username is: " + acc.getName());
				System.out.println("Account Id is: " + acc.getId());
			} else {
				System.out.println(arg);
			}
		}
		
	}
	
}