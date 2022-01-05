package designPatterns.creational.abstractFactory.example_2.device.factories;

import designPatterns.creational.abstractFactory.example_2.device.Desktop;
import designPatterns.creational.abstractFactory.example_2.device.component.cpu.CPUBrand;
import designPatterns.creational.abstractFactory.example_2.device.component.gpu.GPUBrand;
import designPatterns.creational.abstractFactory.example_2.device.component.ram.RAMBrand;
import designPatterns.creational.abstractFactory.example_2.device.componentstorage.StorageBrand;

public class DesktopComputerFactory implements ComputerFactory {

	private DesktopComputerFactory() {}
	
	private static class SingletonHelperClass {
		private static final DesktopComputerFactory INSTANCE =
				new DesktopComputerFactory();
	}
	
	public static DesktopComputerFactory getInstance() {
		return SingletonHelperClass.INSTANCE;
	} 
	
	@Override
	public Desktop buildComputer(ManufacturerType manufacturerType) {
		Desktop desktopComputer = null;
		
		ComponentFactory componentFactory = DesktopComponentFactory.getInstance();
		
		switch (manufacturerType) {
			case CyberPower:
				 desktopComputer = new Desktop("CyberPower Desktop", componentFactory);
				 desktopComputer.assembleComputer(CPUBrand.AMD, RAMBrand.Crucial,
						 GPUBrand.Radeon, StorageBrand.Crucial);
				break;
			case Dell:
				desktopComputer = new Desktop("Dell Desktop", componentFactory);
				desktopComputer.assembleComputer(CPUBrand.Intel, RAMBrand.HyperX,
						GPUBrand.Nvidia, StorageBrand.Samsung);
				break;
			default:	//Do nothing as we don't have Generic Desktop Computer.
		}
		
		return desktopComputer;
	}
	
}
