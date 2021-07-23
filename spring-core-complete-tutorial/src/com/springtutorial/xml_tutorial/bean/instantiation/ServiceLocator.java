package com.springtutorial.xml_tutorial.bean.instantiation;

import com.springtutorial.xml_tutorials.dao.ItemDao;
import com.springtutorial.xml_tutorials.dao.ItemDaoImplementation;
import com.springtutorial.xml_tutorials.service.StoreService;
import com.springtutorial.xml_tutorials.service.UnregisteredService;

/**
 * Static Factory Method example with multiple Static Factory Methods:
 * 
 * @author Vermas-Dell
 */
public class ServiceLocator {
	
	private static ItemDao itemService = new ItemDaoImplementation();
	
	private static StoreService storeService = new UnregisteredService();
	
	public static ItemDao getItemService() {
		return itemService;
	}
	
	public static StoreService getStoreService() {
		return storeService;
	}
	
}