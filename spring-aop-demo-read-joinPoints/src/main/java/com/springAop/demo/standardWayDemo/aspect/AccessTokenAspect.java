package com.springAop.demo.standardWayDemo.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Aspect
@Component
public class AccessTokenAspect {
	
	@Around("execution(* *(..))")
	public Object handleAccessToken(ProceedingJoinPoint thisJoinPoint) throws Throwable {
		System.out.println(thisJoinPoint);
		Object[] args = thisJoinPoint.getArgs();
		
		MethodSignature methodSignature = (MethodSignature) thisJoinPoint.getStaticPart().getSignature();
		Method method = methodSignature.getMethod();
		Annotation[][] parameterAnnotation = method.getParameterAnnotations();
		
		//Will exit with AssertionException if Method argument length is not
		//equal to Parameter Annotation length(Row Length):
		assert args.length == parameterAnnotation.length;
		
		for (int argIndex = 0; argIndex<args.length; argIndex++) {
			for (Annotation annotation : parameterAnnotation[argIndex]) {
				//Will skip over Parameters which are not an instance of RequestParam
				if (!(annotation instanceof RequestParam))
					continue;
				
				//Will skip over RequestParam Parameters whose name is not "accessToken" 
				RequestParam requestParam = (RequestParam) annotation;
				if (!"accessToken".equals(requestParam.value()))
					continue;
				
				System.out.println(" " + requestParam.value() + " = " + args[argIndex]);
			}
		}
		
		return thisJoinPoint.proceed();
	}
	
}