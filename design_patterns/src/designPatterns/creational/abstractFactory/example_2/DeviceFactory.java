package designPatterns.creational.abstractFactory.example_2;

import designPatterns.creational.abstractFactory.example_2.device.factories.ComputerFactory;
import designPatterns.creational.abstractFactory.example_2.device.factories.DesktopComputerFactory;
import designPatterns.creational.abstractFactory.example_2.device.factories.LaptopComputerFactory;

public class DeviceFactory {
	
	private DeviceFactory(){}
	
	private static class SingletonHelperClass {
		private static final DeviceFactory INSTANCE = new DeviceFactory();
	}
	
	public static DeviceFactory getInstance() {
		return SingletonHelperClass.INSTANCE;
	}
	
	public ComputerFactory getComputerFactory(ComputerType deviceType) {
		ComputerFactory factory = null;
		
		switch(deviceType) {
			case Desktop:
				factory = DesktopComputerFactory.getInstance();
				break;
			case Laptop:
				factory = LaptopComputerFactory.getInstance();
				break;
		}
		
		return factory;
	}
}
