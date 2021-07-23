package com.springAop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLoggingAspect {
	
	@Before("com.springAop.demo.aspect.AopDeclarations.forDaoPackageNoGetterSetter()")
	public void logToCloud() {
		System.out.println("===>>>Logging to Cloud");
	}
	
}