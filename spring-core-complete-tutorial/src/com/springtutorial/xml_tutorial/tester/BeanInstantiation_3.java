package com.springtutorial.xml_tutorial.tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springtutorial.xml_tutorial.bean.instantiation.BasicConstructorInstantiation;
import com.springtutorial.xml_tutorial.bean.instantiation.ClientService;
import com.springtutorial.xml_tutorial.bean.instantiation.DefaultClientService;
import com.springtutorial.xml_tutorial.bean.instantiation.OuterClass;
import com.springtutorial.xml_tutorials.dao.ItemDao;
import com.springtutorial.xml_tutorials.service.StoreService;

public class BeanInstantiation_3 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext beanInstantiationContext = new ClassPathXmlApplicationContext("com/springtutorial/xml_tutorial/bean/instantiation/beanInstantiationContext.xml");
		
		OuterClass.StaticInnerClass staticInnerClassObj = beanInstantiationContext.getBean("staticInnerObj", OuterClass.StaticInnerClass.class);
		
		System.out.println("Static Inner Class Int Field is: "+staticInnerClassObj.getInnerId());
		System.out.println("Static Inner Class String Field is: "+staticInnerClassObj.getInnerField());
		
		
		BasicConstructorInstantiation basicConstructorObj = beanInstantiationContext.getBean("basicConstructorBean", BasicConstructorInstantiation.class);
		
		System.out.println("Bean has message: "+basicConstructorObj.getStrField());
		
		
		//Instance of a Bean obtained by Static Factory Method Bean Definition:
		ClientService clientService = beanInstantiationContext.getBean("clientService", ClientService.class);
		
		System.out.println("Class Type of the Bean returned by Static Factory Metghod Bean Definition is: "+clientService.getClass());
		
		//Instances of Beans obtained by Static Factory Method Bean Definition:
		ItemDao itemService = beanInstantiationContext.getBean("itemService", ItemDao.class);
		StoreService storeService = beanInstantiationContext.getBean("storeService", StoreService.class);
		
		System.out.println(itemService.getItemNames());
		System.out.println(storeService.getUserNameList());
		
		
		//Instances of Bean obtained by Instance Factory MethodBean Definition:
		DefaultClientService defaultClientService = beanInstantiationContext.getBean("defaultClientService", DefaultClientService.class);
		
		System.out.println("Instance Factory Method Returned Bean Type is: "+defaultClientService.getClass());
		
		beanInstantiationContext.close();
	}

}
