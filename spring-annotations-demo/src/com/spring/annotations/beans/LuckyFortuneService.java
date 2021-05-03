package com.spring.annotations.beans;

import org.springframework.stereotype.Component;

import com.spring.annotations.interfaces.FortuneService;

@Component
public class LuckyFortuneService implements FortuneService {
	
	@Override
	public String getFortune() {
		return "Its your Lucky Day";
	}

}