package com.spring.annotations.beans;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.spring.annotations.interfaces.FortuneService;

@Component("rFortuneService")
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