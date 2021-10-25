package designPatterns.creational.abstractFactory.gpu;

public class Nvidia_RTX_3080Ti_Mobile extends Mobile_GPU {
	
	public Nvidia_RTX_3080Ti_Mobile() {
		setName("Nvidia RTX 3080Ti Mobile");
		setGPUCoreCount(6144);
		setTensorCoreCount(192);
		setRTCoreCount(48);
		setMemoryCapacity("16 GB");
		setMemoryType("GDDR6");
		setFrequency("1100 MHz");
	}
	
}
