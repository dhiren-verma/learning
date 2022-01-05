package designPatterns.creational.abstractFactory.example_2.device.factories;

import designPatterns.creational.abstractFactory.example_2.device.Laptop;
import designPatterns.creational.abstractFactory.example_2.device.component.cpu.CPUBrand;
import designPatterns.creational.abstractFactory.example_2.device.component.gpu.GPUBrand;
import designPatterns.creational.abstractFactory.example_2.device.component.ram.RAMBrand;
import designPatterns.creational.abstractFactory.example_2.device.componentstorage.StorageBrand;

public class LaptopComputerFactory implements ComputerFactory {

	private LaptopComputerFactory() {}
	
	private static class SingletonHelperClass {
		private static final LaptopComputerFactory INSTANCE =
				new LaptopComputerFactory();
	}
	
	public static LaptopComputerFactory getInstance() {
		return SingletonHelperClass.INSTANCE;
	}
	
	@Override
	public Laptop buildComputer(ManufacturerType manufacturerType) {
		Laptop laptopComputer = null;
		
		LaptopComponentFactory componentFactory = LaptopComponentFactory.getInstance();
		
		switch (manufacturerType) {
			case Asus:
				laptopComputer = new Laptop("ASUS Zephyrus G14", componentFactory);
				laptopComputer.assembleComputer(CPUBrand.AMD, RAMBrand.HyperX,
						GPUBrand.Nvidia, StorageBrand.Crucial);
				break;
			case MSI:
				laptopComputer = new Laptop("MSI Raider GE76", componentFactory);
				laptopComputer.assembleComputer(CPUBrand.Intel, RAMBrand.Crucial,
						GPUBrand.Nvidia, StorageBrand.Crucial);
				break;
			default: //Do nothing as we don't have a Generic Laptop:
		}
		
		return laptopComputer;
	}

}
