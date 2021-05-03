package com.spring.annotations.beans;

import com.spring.annotations.interfaces.FortuneService;

public class SadFortuneService implements FortuneService {

	public String getFortune() {
		return "Today is a Sad Day!";
	}

}