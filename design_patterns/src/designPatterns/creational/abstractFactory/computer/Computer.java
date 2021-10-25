package designPatterns.creational.abstractFactory.computer;

import designPatterns.creational.abstractFactory.cpu.CPU;
import designPatterns.creational.abstractFactory.gpu.GPU;
import designPatterns.creational.abstractFactory.ram.RAM;
import designPatterns.creational.abstractFactory.storage.Storage;

public abstract class Computer {
	
	String name;
	CPU cpu;
	RAM ram;
	GPU gpu;
	Storage storage;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public CPU getCpu() {
		return cpu;
	}
	
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	
	public RAM getRam() {
		return ram;
	}
	
	public void setRam(RAM ram) {
		this.ram = ram;
	}
	
	public GPU getGpu() {
		return gpu;
	}
	
	public void setGpu(GPU gpu) {
		this.gpu = gpu;
	}
	
	public Storage getStorage() {
		return storage;
	}
	
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	
}