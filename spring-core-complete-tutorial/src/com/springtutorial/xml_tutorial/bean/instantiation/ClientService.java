package com.springtutorial.xml_tutorial.bean.instantiation;

/**
 * Static Factory Method example
 * 
 * @author Vermas-Dell
 */
public class ClientService {
	
	private static ClientService instance = new ClientService();
	
	private ClientService() {
	}
	
	public static ClientService getClientService() {
		return instance;
	}
	
}