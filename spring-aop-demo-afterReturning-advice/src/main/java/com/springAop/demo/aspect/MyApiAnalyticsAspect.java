package com.springAop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect {
	
	@Before("com.springAop.demo.aspect.AopDeclarations.forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("===>>>Performing API Analytics");
	}
	
}