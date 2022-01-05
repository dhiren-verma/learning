package designPatterns.creational.abstractFactory.example_2;

import designPatterns.creational.abstractFactory.example_2.device.factories.ComputerFactory;
import designPatterns.creational.abstractFactory.example_2.device.factories.DesktopComputerFactory;
import designPatterns.creational.abstractFactory.example_2.device.factories.LaptopComputerFactory;

public class AbstractDeviceFactory {

	public ComputerFactory getComputerFactory(ComputerType deviceType) {
		ComputerFactory factory = null;
		
		switch(deviceType) {
			case Desktop:
				factory = new DesktopComputerFactory();
				break;
			case Laptop:
				factory = new LaptopComputerFactory();
				break;
		}
		
		return factory;
	}
}
