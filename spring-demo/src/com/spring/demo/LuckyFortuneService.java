package com.spring.demo;

public class LuckyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your Lucky Day!";
	}

}