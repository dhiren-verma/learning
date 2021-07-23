package com.springAop.demo.aspect;

import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.springAop.demo.entity.Account;

@Aspect
@Component
public class AfterReturningLoggingAspect {
	
	@AfterReturning(pointcut="execution(* com.springAop.demo.dao.DemoAccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturingFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		//Read Method Signature:
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println(methodSignature);
		
		System.out.println("AfterReturningLoggingAdvice: after successfully returing findAccounts:");
		
		result.stream().forEach(System.out::println);
		
		//Lets Post Process the fetched Result:
		//Convert the Name to Camel Case:
//		result = result.stream().map(str -> function.apply(str)).collect(Collectors.toList());
		
		result = convertAcountNameToCamelCase(result);
		
	}

	private List<Account> convertAcountNameToCamelCase(List<Account> result) {
		return result.stream()
				.map(account-> {
					StringBuilder transformedName = new StringBuilder();
					
					if (!account.getName().isEmpty()) {
						transformedName.append(account.getName().substring(0, 1).toUpperCase());
						
						if (account.getName().length()>1) {
							transformedName.append(account.getName().substring(1, account.getName().length()).toLowerCase());
						}
					}
					
					account.setName(transformedName.toString());
					
					return account;
				})
				.collect(Collectors.toList());
	}
	
//	Function<Account, Account> function = new Function<Account, Account>() {
//		
//		@Override
//		public Account apply(Account account) {
//			StringBuilder transformedName = new StringBuilder();
//			
//			if (!account.getName().isEmpty()) {
//				transformedName.append(account.getName().substring(0, 1).toUpperCase());
//				
//				if (account.getName().length()>1) {
//					transformedName.append(account.getName().substring(1, account.getName().length()).toLowerCase());
//				}
//			}
//			
//			account.setName(transformedName.toString());
//			
//			return account;
//		}
//		
//	};
	
}