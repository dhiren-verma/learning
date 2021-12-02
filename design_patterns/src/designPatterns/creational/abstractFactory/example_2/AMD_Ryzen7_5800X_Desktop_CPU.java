package designPatterns.creational.abstractFactory.example_2;

public class AMD_Ryzen7_5800X_Desktop_CPU extends CPU {

	public AMD_Ryzen7_5800X_Desktop_CPU() {
		brand = CPUBrand.AMD;
		name = "5th Gen. Ryzen7 5800X";
		componentClass = ComponentClass.Desktop;
		coreCount = 8;
		supportsHyperthreading = true;
		pcieVersion = "4.0";
		frequency = "3.80 GHz";
		turboFrequency = "4.70 GHz";
		l1Cache = "512 KB";
		l2Cache = "4 MB";
		l3Cache = "32 MB";
	}
	
}
