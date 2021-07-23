package com.springAop.demo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneService {
	
	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Expect heavy traffc this Morning!";
	}
	
	public String getFortune(boolean raiseException) {
		if (raiseException)
			throw new RuntimeException("Major Accident! Highway is closed...");
		
		return getFortune();
	}
	
}