package designPatterns.creational.abstractFactory.example_2;

public class Laptop extends Computer {

	private ComponentFactory componentFactory;
	
	public Laptop(String name, ComponentFactory componentFactory) {
		super(name);
		this.componentFactory = componentFactory;
	}
	
	@Override
	void assembleComputer(CPUBrand cpuBrand, RAMBrand ramBrand, GPUBrand gpuBrand, StorageBrand storageBrand) {
		 cpu = componentFactory.getCPU(cpuBrand);
		 ram = componentFactory.getRam(ramBrand);
		 gpu = componentFactory.getGpu(gpuBrand);
		 storage = componentFactory.getStorage(storageBrand);
	}

}
