package designPatterns.creational.abstractFactory.gpu;

public class Radeon_RX_6800M_Mobile extends Mobile_GPU {
	
	public Radeon_RX_6800M_Mobile() {
		setName("Radeon RX 6800M Mobile");
		setGPUCoreCount(2560);
		setTensorCoreCount(0);
		setRTCoreCount(40);
		setMemoryCapacity("12 GB");
		setMemoryType("GDDR6");
		setFrequency("2321 MHz");
	}
	
}