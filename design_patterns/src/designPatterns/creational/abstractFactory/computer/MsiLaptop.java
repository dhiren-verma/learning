package designPatterns.creational.abstractFactory.computer;

import designPatterns.creational.abstractFactory.cpu.Laptop_CPU;
import designPatterns.creational.abstractFactory.gpu.Mobile_GPU;
import designPatterns.creational.abstractFactory.ram.Laptop_RAM;
import designPatterns.creational.abstractFactory.storage.Storage;

public class MsiLaptop extends Computer {
	
	public MsiLaptop(String name, Laptop_CPU cpu, Laptop_RAM ram, Mobile_GPU gpu, Storage storage) {
		this.name = name;
		this.cpu = cpu;
		this.ram = ram;
		this.gpu = gpu;
		this.storage = storage;
	}

	@Override
	public String toString() {
		return name + " " + "Laptop\n"
				+ "CPU: " + cpu + "\n"
				+ "RAM: " + ram + "\n"
				+ "GPU: " + gpu + "\n"
				+ "Storage: " + storage + "]";
	}
	
}