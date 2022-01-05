package designPatterns.creational.abstractFactory.example_2.device.component.cpu;

import designPatterns.creational.abstractFactory.example_2.device.component.ComponentClass;

public class Intel_i7_11700K_Desktop_CPU extends CPU {
	
	public Intel_i7_11700K_Desktop_CPU() {
		brand = CPUBrand.Intel;
		name = "11th Gen. Core i7 11700K";
		componentClass = ComponentClass.Desktop;
		coreCount = 8;
		supportsHyperthreading = true;
		pcieVersion = "4.0";
		frequency = "3.60 GHz";
		turboFrequency = "5.00 GHz";
		l1Cache = "512 KB";
		l2Cache = "2 MB";
		l3Cache = "16 MB";
	}
	
}
