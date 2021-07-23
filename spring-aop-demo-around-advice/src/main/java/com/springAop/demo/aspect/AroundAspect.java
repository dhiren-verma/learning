package com.springAop.demo.aspect;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAspect {
	
	@Around("execution(* com.springAop.demo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint)
			throws Throwable {
		//Printout the Method we are advicing on:
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
		System.out.println("===>>>Executing @Around Advice on: "+methodSignature);
		
		//Get Begin Timestamp:
		long beginTimeStamp = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
		
		//Now, lets execute the Method:
		Object returnValues = proceedingJoinPoint.proceed();
		
		//Get End Timestamp:
		long endTimeStamp = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
		
		//Compute Duration & log it:
		System.out.println("Total Time taken for method execution in seconds is: "+(endTimeStamp-beginTimeStamp));
		
		return returnValues;
	}
	
}
