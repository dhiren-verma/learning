package designPatterns.creational.abstractFactory.gpu;

public class Radeon_RX_6800XT extends Desktop_GPU {
	
	public Radeon_RX_6800XT() {
		setName("Radeon RX 6800XT");
		setBrand("ASUS");
		setGPUCoreCount(4608);
		setTensorCoreCount(0);
		setRTCoreCount(72);
		setMemoryCapacity("16 GB");
		setMemoryType("GDDR6");
		setFrequency("1825 MHz");
	}
	
}