package com.learning.spring_security_demo_thymeleaf.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCDispatcherServletInitializer
		extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SpringThymeleafDemoAppConfig.class};
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
}