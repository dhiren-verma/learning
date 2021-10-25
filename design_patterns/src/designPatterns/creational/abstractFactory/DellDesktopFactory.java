package designPatterns.creational.abstractFactory;

import designPatterns.creational.abstractFactory.computer.Computer;
import designPatterns.creational.abstractFactory.computer.DellDesktop;
import designPatterns.creational.abstractFactory.cpu.CPU;
import designPatterns.creational.abstractFactory.cpu.Desktop_CPU;
import designPatterns.creational.abstractFactory.cpu.Intel_i7_11700K_Desktop_CPU;
import designPatterns.creational.abstractFactory.gpu.Desktop_GPU;
import designPatterns.creational.abstractFactory.gpu.Nvidia_RTX_3080Ti;
import designPatterns.creational.abstractFactory.ram.Crucial_Ballistix_32GB;
import designPatterns.creational.abstractFactory.ram.Desktop_RAM;
import designPatterns.creational.abstractFactory.storage.Seagate_BarraCuda;
import designPatterns.creational.abstractFactory.storage.Storage;

public class DellDesktopFactory implements ComputerAbstractFactory {
	
	@Override
	public Computer createComputer() {
		String name = "Dell Inspiron 3880";
		Desktop_CPU cpu = new Intel_i7_11700K_Desktop_CPU();
		Desktop_RAM ram = new Crucial_Ballistix_32GB();
		Desktop_GPU gpu = new Nvidia_RTX_3080Ti();
		Storage storage = new Seagate_BarraCuda(); 
		
		return new DellDesktop(name, cpu, ram, gpu, storage);
	}
	
}