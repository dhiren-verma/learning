package com.springAop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
	
	//Here we add all of our Related Advice for Logging:
	
	//Pointcut Declaration:
	@Pointcut("execution(* com.springAop.demo.dao.*.*(..))")
	private void forDaoPackage() { }
	
	@Pointcut("execution(* com.springAop.demo.dao.*.get*(..))")
	private void forDaoPackageGetters() { }
	
	@Pointcut("execution(* com.springAop.demo.dao.*.set*(..))")
	private void forDaoPackageSetters() {}
	
	@Pointcut("forDaoPackage() &&!(forDaoPackageGetters() || forDaoPackageSetters())")
	private void forDaoPackageNoGetterSetter() {}
	
	//Using Declared Pointcut:
//	@Before("forDaoPackage()")
//	@Before("forDaoPackageGetters()")
//	@Before("forDaoPackageSetters()")
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeDaoPackageMethodAdvice() {
		System.out.println("===>>>Executing @Before Advice on mentioned Method");
	}
	
}