package com.springtutorial.xml_tutorial.bean.instantiation;

/**
 * Instance Factory Method example:
 * 
 * @author Vermas-Dell
 */
public class DefaultServiceLocater {
	
	private static DefaultClientService clientService = new DefaultClientService();
	
	public DefaultClientService getDefaultClientService() {
		return clientService;
	}
	
}