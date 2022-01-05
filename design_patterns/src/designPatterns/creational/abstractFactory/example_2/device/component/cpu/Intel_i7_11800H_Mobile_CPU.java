package designPatterns.creational.abstractFactory.example_2.device.component.cpu;

import designPatterns.creational.abstractFactory.example_2.device.component.ComponentClass;

public class Intel_i7_11800H_Mobile_CPU extends CPU {

	public Intel_i7_11800H_Mobile_CPU() {
		brand = CPUBrand.Intel;
		name = "11th Gen. Core i7 11800H";
		componentClass = ComponentClass.Mobile;
		coreCount = 8;
		supportsHyperthreading = true;
		pcieVersion = "4.0";
		frequency = "2.30 GHz";
		turboFrequency = "4.60 GHz";
		l1Cache = "768 KB";
		l2Cache = "10 MB";
		l3Cache = "24 MB";
	}

}
