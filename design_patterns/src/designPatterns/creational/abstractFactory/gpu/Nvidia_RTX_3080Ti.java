package designPatterns.creational.abstractFactory.gpu;

public class Nvidia_RTX_3080Ti extends Desktop_GPU {
	
	public Nvidia_RTX_3080Ti() {
		setName("Nvidia rtx 3080Ti");
		setBrand("EVGA");
		setGPUCoreCount(10240);
		setTensorCoreCount(320);
		setRTCoreCount(80);
		setMemoryCapacity("12 GB");
		setMemoryType("GDDR6X");
		setFrequency("1370 MHz");
	}
	
}