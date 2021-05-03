package spring.mvc.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcDispatcherServletInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
	
	//Step 1: Configure/Provide Spring MVC Dispatcher Servlet:
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringDemoAppConfig.class };
	}
	
	//Step 2: Setup URL Mappings to Spring MVC Dispatcher Servlet:
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
}