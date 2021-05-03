package com.spring.demo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	private String[] fortunes = {
			"Its the Day of Hard Workers",
			"Your Hard Work will pay off, keep working hard!",
			"Never let down, always keep going"
	};
	
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		return fortunes[random.nextInt(fortunes.length)];
	}
	
}