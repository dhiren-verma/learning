package designPatterns.creational.abstractFactory;

import designPatterns.creational.abstractFactory.computer.Computer;

public class ComputerFactory {
	
	public static Computer getComputer(ComputerAbstractFactory factory) {
		return factory.createComputer();
	}
	
}