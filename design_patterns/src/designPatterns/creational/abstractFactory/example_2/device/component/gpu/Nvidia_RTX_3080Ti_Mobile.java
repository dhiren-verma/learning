package designPatterns.creational.abstractFactory.example_2.device.component.gpu;

import designPatterns.creational.abstractFactory.example_2.device.component.ComponentClass;

public class Nvidia_RTX_3080Ti_Mobile extends GPU {

	public Nvidia_RTX_3080Ti_Mobile() {
		secBrand = "";
		brand = GPUBrand.Nvidia;
		name = "RTX 3080Ti";
		memoryCapacity = "16 GB";
		memoryType = "GDDR6";
		componentClass = ComponentClass.Mobile;
		frequency = "1100 MHz";
		gpuCoreCount = 6144;
		tensorCoreCount = 192;
		rtCoreCount = 48;
	}
	
}
