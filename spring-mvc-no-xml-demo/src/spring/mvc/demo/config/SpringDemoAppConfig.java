package spring.mvc.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
//Step 4: Add Support for conversion, formatting & validation:
@EnableWebMvc
//Step 3: Add support for Component Scan:
@ComponentScan(basePackages = "spring.mvc.demo")

//Support for Reading from Properties File:
//@PropertySource("classpath:sport.properties")
public class SpringDemoAppConfig {
	
	//Step 5: Configure a Spring MVC View Resolver:
	//Define a Bean for View Resolver:
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
}