package com.spring.annotations.springConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.spring.annotations.beans.BoxingCoach;
import com.spring.annotations.beans.SadFortuneService;
import com.spring.annotations.interfaces.Coach;
import com.spring.annotations.interfaces.FortuneService;

@Configuration
@ComponentScan("com.spring.annotations.beans")
@ComponentScan("com.spring.annotations.util")
@PropertySource("classpath:sport.properties")
public class SpringConfiguration {
	
	//Method Name is the actual Bean Id for this Bean:
	@Bean
//	@Scope("prototype")
	public FortuneService getFortuneService() {
		return new SadFortuneService();
	}
	
	//Method Name is the actual Bean Id for this Bean:
	@Bean
	@Scope("prototype")
	public Coach boxingCoach() {
		return new BoxingCoach(getFortuneService());
	}
	
}