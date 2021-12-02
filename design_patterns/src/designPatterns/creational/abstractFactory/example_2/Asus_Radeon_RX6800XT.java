package designPatterns.creational.abstractFactory.example_2;

public class Asus_Radeon_RX6800XT extends GPU {

	public Asus_Radeon_RX6800XT() {
		secBrand = "Asus";
		brand = GPUBrand.Radeon;
		name = "RX 6800XT";
		memoryCapacity = "16 GB";
		memoryType = "GDDR6";
		componentClass = ComponentClass.Desktop;
		frequency = "1825 MHz";
		gpuCoreCount = 4608;
		tensorCoreCount = 0;
		rtCoreCount = 72;
	}
	
}
