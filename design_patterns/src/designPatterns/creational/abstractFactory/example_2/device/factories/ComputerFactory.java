package designPatterns.creational.abstractFactory.example_2.device.factories;

import designPatterns.creational.abstractFactory.example_2.device.Computer;

public interface ComputerFactory {
	
	default Computer orderComputer(ManufacturerType manufacturerType) {
		Computer computer = buildComputer(manufacturerType);		
		
		if (testComputer(computer))
			return computer;
		else
			return null;
		
	}
	
	Computer buildComputer(ManufacturerType manufacturerType);
	
	default boolean testComputer(Computer computer) {
		if (computer ==null)
			return false;
		
		if (computer.getCpu() == null)
			return false;
		
		if (computer.getRam() == null)
			return false;
		
		if (computer.getGpu() == null)
			return false;
		
		if (computer.getStorage() == null)
			return false;
		
		if (computer.getName() == null ||
				computer.getName().isEmpty())
			return false;
		
		return true;
	}
	
}
