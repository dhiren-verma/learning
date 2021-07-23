package com.springAop.demo.standardWayDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.springAop.demo.DemoConfig;

@Component
public class MyResponse {
	
	public MyResponse saveUser(
			@RequestParam("accessToken") String accessToken,
			@RequestBody final UserDto userDto) {
		System.out.println("saveUser()");
		return this;
	}
	
	public MyResponse doSomething(
			@RequestParam("someParameter")String text,
			@RequestBody final UserDto userDto) {
		System.out.println("doSomething()");
		return this;
	}
	
	public MyResponse doSomethingElse(
			@RequestParam("accessToken") int number) {
		System.out.println("doSomethingElse()");
		return this;
	}
	
	public MyResponse somethingNew(String text,
			UserDto userDto) {
		return this;
	}
	
	public static void main(String[] args) {
		/**
		 * Problem statement is that we need to log @RequestParam("accessToken")
		 * Parameter in all methods where its being passed.
		 * One way to do it is check for the the names of the Parameters that get
		 * passed internally as per their declaration, so lets say that all
		 * @RequestParam("accessToken") are being associated with
		 * 'String accessToken' in respective methods, so we can extract from
		 * matching names on the internally passed Parameters, but this is not a
		 * good practice, because of the following reasons:
		 * (a) bad design
		 * (b) brittle (breaking if someone renames a method parameter)
		 * (c) in this case unnecessary because we can simply match the parameter's annotation
		 * (d) not working if compiled without debug info
		 * 
		 * So what we can do is specifically filter out on the basis of
		 * @RequestParam("accessToken")
		 */
		
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext(DemoConfig.class);
		
		MyResponse myResponse  = context.getBean("myResponse", MyResponse.class);
		
		myResponse.doSomething("I'm not a Token", new UserDto());
		myResponse.doSomethingElse(123456);
		myResponse.saveUser("I'm a Token", new UserDto());
		myResponse.somethingNew("Hello World", new UserDto());
		
		context.close();
		
	}
	
}
