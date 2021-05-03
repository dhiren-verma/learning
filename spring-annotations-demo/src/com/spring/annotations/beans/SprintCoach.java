package com.spring.annotations.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.annotations.interfaces.Coach;
import com.spring.annotations.interfaces.FortuneService;

@Component("sCoach")
public class SprintCoach implements Coach {
	
	private FortuneService fortuneProvider;
	
	//Constructor Dependency Injection with Auto-Wiring
	//Fun Fact - was also working without @Autowired Annotation, why?
	//Answer: As of Spring Framework 4.3, an @Autowired annotation on
	//		  such a constructor is no longer necessary if the target
	//		  bean only defines one constructor to begin with. However,
	//		  if several constructors are available, at least one must
	//		  be annotated to teach the container which one to use.
	//NOTE: Auto-Wiring is prone to fail if there are multiple
	//		Implementations available for the required Dependency.
	//		It throws "NoUniqueBeanDefinitionException" in such case.
	//		In that case we can use @Qualifier Annotation with Default
	//		Bean Id or given Bean Id of the expected Dependency.
	//Constructor AutoWiring with Constructor is an Special Case:
	@Autowired
	public SprintCoach(@Qualifier("fileFortuneService") FortuneService fortuneProvider) {
		this.fortuneProvider = fortuneProvider;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run 5000m in 30 minutes";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneProvider.getFortune();
	}
	
}