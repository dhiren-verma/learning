package com.springAop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class DemoLoggingAspect {
	
	//Using Declared Pointcut:
//	@Before("com.springAop.demo.aspect.AopDeclarations.forDaoPackage()")
//	@Before("com.springAop.demo.aspect.AopDeclarations.forDaoPackageGetters()")
//	@Before("com.springAop.demo.aspect.AopDeclarations.forDaoPackageSetters()")
	@Before("com.springAop.demo.aspect.AopDeclarations.forDaoPackageNoGetterSetter()")
	public void beforeDaoPackageMethodAdvice() {
		System.out.println("===>>>Executing @Before Advice for Add Account");
	}
	
}