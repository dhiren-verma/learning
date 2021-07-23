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
		//Just a Demonstrative Flag, don't use it like that in Production:
		boolean propagateException = false;
		
		//Printout the Method we are advising on:
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
		System.out.println("===>>>Executing @Around Advice on: "+methodSignature);
		
		//Get Begin Timestamp:
		long beginTimeStamp = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
		
		//Now, lets execute the Method:
		Object returnValues = null;
		
		try {
			returnValues = proceedingJoinPoint.proceed();
		} catch (Exception ex) {
			//Log the Exception:
			System.out.println(ex);
			
			//Here in this approach we are handling/swallowing/stopping the Exception:
			//We may also re-throw the same Exception if we don't want to handle/swallow/stop the Exception:
			
			if (propagateException) {
				//Propagate/Throw the catched Exception:
				throw ex;
			} else {
				//Give user a Custom Message:
				returnValues = ex.getMessage()+" you may choose some other Route!";
			}
			
		}
		
		//Get End Timestamp:
		long endTimeStamp = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
		
		//Compute Duration & log it:
		System.out.println("Total Time taken for method execution in seconds is: "+(endTimeStamp-beginTimeStamp));
		
		return returnValues;
	}
	
}
