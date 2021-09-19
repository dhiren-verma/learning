package com.learning.spring_crm_rest_demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCDispathcerServletInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {DemoAppConfig.class};
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
}