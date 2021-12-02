package designPatterns.creational.abstractFactory.example_2;

public class DesktopComputerFactory implements ComputerFactory {

	@Override
	public Desktop buildComputer(ManufacturerType manufacturerType) {
		Desktop desktopComputer = null;
		
		ComponentFactory componentFactory = new DesktopComponentFactory();
		
		switch (manufacturerType) {
			case CyberPower:
				 desktopComputer = new Desktop("CyberPower Desktop", componentFactory);
				 desktopComputer.assembleComputer(CPUBrand.AMD, RAMBrand.Crucial, GPUBrand.Radeon, StorageBrand.Crucial);
				break;
			case Dell:
				desktopComputer = new Desktop("Dell Desktop", componentFactory);
				desktopComputer.assembleComputer(CPUBrand.Intel, RAMBrand.HyperX, GPUBrand.Nvidia, StorageBrand.Samsung);
				break;
			default:	//Do nothing as we don't have Generic Desktop Computer.
		}
		
		return desktopComputer;
	}
	
}
