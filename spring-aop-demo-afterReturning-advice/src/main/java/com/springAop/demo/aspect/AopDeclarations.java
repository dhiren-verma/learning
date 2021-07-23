package com.springAop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopDeclarations {
	
	//Pointcut Declaration:
	@Pointcut("execution(* com.springAop.demo.dao.*.*(..))")
	public void forDaoPackage() { }
	
	@Pointcut("execution(* com.springAop.demo.dao.*.get*(..))")
	public void forDaoPackageGetters() { }
	
	@Pointcut("execution(* com.springAop.demo.dao.*.set*(..))")
	public void forDaoPackageSetters() {}
	
	@Pointcut("forDaoPackage() &&!(forDaoPackageGetters() || forDaoPackageSetters())")
	public void forDaoPackageNoGetterSetter() {}
	
}