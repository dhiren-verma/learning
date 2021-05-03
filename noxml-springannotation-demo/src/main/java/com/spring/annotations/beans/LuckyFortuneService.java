package com.spring.annotations.beans;

import org.springframework.stereotype.Component;

import com.spring.annotations.interfaces.FortuneService;

@Component
public class LuckyFortuneService implements FortuneService {

	public String getFortune() {
		return "Today is your Lucky Day!";
	}

}
