package com.springtutorial.xml_tutorial.tester;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.springtutorial.xml_tutorials.service.StoreService;
import com.springtutorial.xml_tutorials.service.UnregisteredService;

public class ImplementationChecker_1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//One way is using the ClassPathXmlApplicationContext: this considers the provided Resource in reference to current 'classpath':
//		ApplicationContext context  = new ClassPathXmlApplicationContext("com/springtutorial/xml_tutorials/service/services_1.xml",
//				"com/springtutorial/xml_tutorials/dao/daos_1.xml"); 
		
		//Second way is using FileSystemXmlApplicationContext: this considers the provided Resource in reference to either their Relative Path or Absolute Path, whichever is provided:
//		ApplicationContext context  = new FileSystemXmlApplicationContext("/src/com/springtutorial/xml_tutorials/service/services_1.xml",
//				"/src/com/springtutorial/xml_tutorials/dao/daos_1.xml");
		
		//Third way is to use GenericApplicationContext with XMLBeanDefinitionReader:
		GenericApplicationContext context = new GenericApplicationContext();
		new XmlBeanDefinitionReader(context).loadBeanDefinitions(new String[] {"com/springtutorial/xml_tutorials/service/services_1.xml",
				"com/springtutorial/xml_tutorials/dao/daos_1.xml"});
		context.refresh();
		
		StoreService storeService = context.getBean("cookieStore", StoreService.class);
		
		System.out.println("Items available in Cookie Store are: "+storeService.getItemNameList());
		
		//Lets check if we can load some UnregisteredBeans now in the Container:
		StoreService unregisteredService = new UnregisteredService();
		
		//This method returns an instance of DefaultListableBeanFactory:
		//DefaultListableBean Interface provides the method o avail the functionality
		//to register external Java Objects with the BeanFacory represented by this
		//Instance of DefaultListableBeanFactory:  
		DefaultListableBeanFactory factory = (DefaultListableBeanFactory) context.getBeanFactory();
		
		//Mow lets register one external Java Object as a Singleton Bean, in the Container: 
		factory.registerSingleton("unregisteredService", unregisteredService);
		
		//Now lets try to get this new Bean from the Container:
		StoreService newStoreService = context.getBean("unregisteredService", StoreService.class);
		
		System.out.println(newStoreService.getItemNameList());
		
		//How to check the Type of a Bean using Spring Library itself:
		System.out.println(context.getBeanFactory().getType("unregisteredService"));
		//How to check the Type of a Bean using simple Java:
		System.out.println(newStoreService.getClass());
		
		//Lets close the Container:
		context.close();
		
	}
		
}
