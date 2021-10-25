package designPatterns.creational.abstractFactory;

import designPatterns.creational.abstractFactory.computer.Computer;
import designPatterns.creational.abstractFactory.computer.CyberPowerDesktop;
import designPatterns.creational.abstractFactory.cpu.Amd_Ryzen7_5800X_Desktop_CPU;
import designPatterns.creational.abstractFactory.cpu.Desktop_CPU;
import designPatterns.creational.abstractFactory.gpu.Desktop_GPU;
import designPatterns.creational.abstractFactory.gpu.Radeon_RX_6800XT;
import designPatterns.creational.abstractFactory.ram.Crucial_Ballistix_32GB;
import designPatterns.creational.abstractFactory.ram.Desktop_RAM;
import designPatterns.creational.abstractFactory.storage.CrucialP5_NVME_SSD;
import designPatterns.creational.abstractFactory.storage.Storage;

/**
 * 
 * @author Dhirendra Verma
 */
public class CyberPowerDesktopFactory implements ComputerAbstractFactory {
	
	@Override
	public Computer createComputer() {
		String name = "CyberPower Infinity X109";
		Desktop_CPU cpu = new Amd_Ryzen7_5800X_Desktop_CPU();
		Desktop_RAM ram = new Crucial_Ballistix_32GB();
		Desktop_GPU gpu = new Radeon_RX_6800XT();
		Storage storage = new CrucialP5_NVME_SSD(); 
		
		return new CyberPowerDesktop(name, cpu, ram, gpu, storage);
	}
	
}