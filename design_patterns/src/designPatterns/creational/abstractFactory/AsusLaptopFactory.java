package designPatterns.creational.abstractFactory;

import designPatterns.creational.abstractFactory.computer.AsusLaptop;
import designPatterns.creational.abstractFactory.computer.Computer;
import designPatterns.creational.abstractFactory.cpu.Amd_Ryzen7_5800HS_Mobile_CPU;
import designPatterns.creational.abstractFactory.cpu.CPU;
import designPatterns.creational.abstractFactory.gpu.Mobile_GPU;
import designPatterns.creational.abstractFactory.gpu.Nvidia_RTX_3080Ti_Mobile;
import designPatterns.creational.abstractFactory.ram.Crucial_16GB_SODIMM;
import designPatterns.creational.abstractFactory.ram.Laptop_RAM;
import designPatterns.creational.abstractFactory.storage.CrucialP5_NVME_SSD;
import designPatterns.creational.abstractFactory.storage.Storage;

public class AsusLaptopFactory implements ComputerAbstractFactory {
	
	@Override
	public Computer createComputer() {
		String name = "Asus ROG Zephyrus G14";
		CPU cpu = new Amd_Ryzen7_5800HS_Mobile_CPU();
		Laptop_RAM ram = new Crucial_16GB_SODIMM();
		Mobile_GPU gpu = new Nvidia_RTX_3080Ti_Mobile();
		Storage storage = new CrucialP5_NVME_SSD(); 
		
		return new AsusLaptop(name, cpu, ram, gpu, storage);
	}
	
}