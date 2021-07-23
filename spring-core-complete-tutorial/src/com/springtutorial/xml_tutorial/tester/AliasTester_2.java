package com.springtutorial.xml_tutorial.tester;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.springtutorial.xml_tutorials.service.StoreService;

public class AliasTester_2 {
	
	public static void main(String[] args) {
		ApplicationContext daoContext = new FileSystemXmlApplicationContext("/src/com/springtutorial/xml_tutorials/dao/alias_daos_2.xml");
		ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"com/springtutorial/xml_tutorials/service/alias_services_2.xml"}, daoContext);
		
		//Now lets try to fetch CookieStore Bean using different Aliases:
		StoreService storeService = appContext.getBean("cookieStore", StoreService.class);
		
		System.out.println("Items available are: "+storeService.getItemNameList());
		
		
		StoreService storeService_1 = appContext.getBean("myCookieStore", StoreService.class);
		
		System.out.println("Users are: "+storeService_1.getUserNameList());
		
		
		StoreService storeService_2 = appContext.getBean("firstCookeStore", StoreService.class);
		
		System.out.println("Revised Items available are: "+storeService_2.getItemNameList());
		
		
		StoreService storeService_3 = appContext.getBean("onlyCookieStore", StoreService.class);
		
		System.out.println("Revised Users are: "+storeService_3.getUserNameList());
		
		
		StoreService storeService_4 = appContext.getBean("aCookieStore", StoreService.class);
		
		System.out.println("Currently Items available are: "+storeService_4.getItemNameList());
		System.out.println("Currently Users are: "+storeService_3.getUserNameList());
		
	}
	
}
