package designPatterns.creational.abstractFactory.computer;

import designPatterns.creational.abstractFactory.cpu.Desktop_CPU;
import designPatterns.creational.abstractFactory.gpu.Desktop_GPU;
import designPatterns.creational.abstractFactory.ram.Desktop_RAM;
import designPatterns.creational.abstractFactory.storage.Storage;

public class DellDesktop extends Computer {
	
	public DellDesktop(String name, Desktop_CPU cpu, Desktop_RAM ram, Desktop_GPU gpu, Storage storage) {
		this.name = name;
		this.cpu = cpu;
		this.ram = ram;
		this.gpu = gpu;
		this.storage = storage;
	}

	@Override
	public String toString() {
		return name + " " + " Desktop\n"
				+ "CPU: " + cpu + "\n"
				+ "RAM: " + ram + "\n"
				+ "GPU: " + gpu + "\n"
				+ "Storage: " + storage + "]";
	}
	
}