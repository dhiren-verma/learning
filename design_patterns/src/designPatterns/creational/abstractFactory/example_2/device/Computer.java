package designPatterns.creational.abstractFactory.example_2.device;

import designPatterns.creational.abstractFactory.example_2.device.component.cpu.CPU;
import designPatterns.creational.abstractFactory.example_2.device.component.cpu.CPUBrand;
import designPatterns.creational.abstractFactory.example_2.device.component.gpu.GPU;
import designPatterns.creational.abstractFactory.example_2.device.component.gpu.GPUBrand;
import designPatterns.creational.abstractFactory.example_2.device.component.ram.RAM;
import designPatterns.creational.abstractFactory.example_2.device.component.ram.RAMBrand;
import designPatterns.creational.abstractFactory.example_2.device.componentstorage.Storage;
import designPatterns.creational.abstractFactory.example_2.device.componentstorage.StorageBrand;

public abstract class Computer {
	
	private final String name;
	CPU cpu;
	RAM ram;
	GPU gpu;
	Storage storage;
	
	public Computer(String name) {
		this.name = name;
	}
	
	public abstract void assembleComputer(CPUBrand cpuBrand, RAMBrand ramBrand,
			GPUBrand gpuBrand, StorageBrand storageBrand);
	
	public String getName() {
		return name;
	}
	
	public CPU getCpu() {
		return cpu;
	}
	
	public RAM getRam() {
		return ram;
	}
	
	public GPU getGpu() {
		return gpu;
	}
	
	public Storage getStorage() {
		return storage;
	}
	
	public String displayComputerSpecs() {
		StringBuilder descBuilder = new StringBuilder(name);
		descBuilder.append("\nwith Specifications:");
		descBuilder.append("\nCPU: ").append(cpu);
		descBuilder.append("\nRAM: ").append(ram);
		descBuilder.append("\nGPU: ").append(gpu);
		descBuilder.append("\nStorage: ").append(storage);
		
		return descBuilder.toString();
	}
	
}
