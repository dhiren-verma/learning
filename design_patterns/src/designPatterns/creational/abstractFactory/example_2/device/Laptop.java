package designPatterns.creational.abstractFactory.example_2.device;

import designPatterns.creational.abstractFactory.example_2.device.component.cpu.CPUBrand;
import designPatterns.creational.abstractFactory.example_2.device.component.gpu.GPUBrand;
import designPatterns.creational.abstractFactory.example_2.device.component.ram.RAMBrand;
import designPatterns.creational.abstractFactory.example_2.device.componentstorage.StorageBrand;
import designPatterns.creational.abstractFactory.example_2.device.factories.ComponentFactory;

public class Laptop extends Computer {

	private ComponentFactory componentFactory;
	
	public Laptop(String name, ComponentFactory componentFactory) {
		super(name);
		this.componentFactory = componentFactory;
	}
	
	@Override
	public void assembleComputer(CPUBrand cpuBrand, RAMBrand ramBrand,
			GPUBrand gpuBrand, StorageBrand storageBrand) {
		 cpu = componentFactory.getCPU(cpuBrand);
		 ram = componentFactory.getRam(ramBrand);
		 gpu = componentFactory.getGpu(gpuBrand);
		 storage = componentFactory.getStorage(storageBrand);
	}

}
