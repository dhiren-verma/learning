package designPatterns.creational.abstractFactory.example_2;

public class EVGA_Nvidia_RTX_3080Ti extends GPU {

	public EVGA_Nvidia_RTX_3080Ti() {
		secBrand = "EVGA";
		brand = GPUBrand.Nvidia;
		name = "RTX 3080Ti";
		memoryCapacity = "12 GB";
		memoryType = "GDDR6X";
		componentClass = ComponentClass.Desktop;
		frequency = "1370 MHz";
		gpuCoreCount = 10240;
		tensorCoreCount = 320;
		rtCoreCount = 80;
	}
	
}
