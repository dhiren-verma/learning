package designPatterns.creational.abstractFactory;

import designPatterns.creational.abstractFactory.computer.Computer;
import designPatterns.creational.abstractFactory.computer.MsiLaptop;
import designPatterns.creational.abstractFactory.cpu.Intel_i7_11800H_Mobile_CPU;
import designPatterns.creational.abstractFactory.cpu.Laptop_CPU;
import designPatterns.creational.abstractFactory.gpu.Mobile_GPU;
import designPatterns.creational.abstractFactory.gpu.Radeon_RX_6800M_Mobile;
import designPatterns.creational.abstractFactory.ram.Crucial_16GB_SODIMM;
import designPatterns.creational.abstractFactory.ram.Laptop_RAM;
import designPatterns.creational.abstractFactory.storage.Samsung870QVO_SSD;
import designPatterns.creational.abstractFactory.storage.Storage;

/**
 * 
 * @author Dhirendra Verma
 */
public class MSILaptopFactory implements ComputerAbstractFactory {
	
	@Override
	public Computer createComputer() {
		String name = "MSI Katana GF66 Thin";
		Laptop_CPU cpu = new Intel_i7_11800H_Mobile_CPU();
		Laptop_RAM ram = new Crucial_16GB_SODIMM();
		Mobile_GPU gpu = new Radeon_RX_6800M_Mobile();
		Storage storage = new Samsung870QVO_SSD(); 
		
		return new MsiLaptop(name, cpu, ram, gpu, storage);
	}
	
}