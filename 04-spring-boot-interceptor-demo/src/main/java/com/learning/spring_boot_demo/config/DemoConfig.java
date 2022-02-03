package com.learning.spring_boot_demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.learning.spring_boot_demo.interceptor.DemoInterceptor;

@Configuration
public class DemoConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new DemoInterceptor()).addPathPatterns("/*");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
}
