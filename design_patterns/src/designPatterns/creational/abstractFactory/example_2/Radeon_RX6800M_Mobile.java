package designPatterns.creational.abstractFactory.example_2;

public class Radeon_RX6800M_Mobile extends GPU {

	public Radeon_RX6800M_Mobile() {
		secBrand = "";
		brand = GPUBrand.Radeon;
		name = "RX 6800M";
		memoryCapacity = "12 GB";
		memoryType = "GDDR6";
		componentClass = ComponentClass.Mobile;
		frequency = "2321 MHz";
		gpuCoreCount = 2560;
		tensorCoreCount = 0;
		rtCoreCount = 40;
	}
	
}
