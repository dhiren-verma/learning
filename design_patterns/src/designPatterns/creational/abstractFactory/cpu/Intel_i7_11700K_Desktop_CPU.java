package designPatterns.creational.abstractFactory.cpu;

public class Intel_i7_11700K_Desktop_CPU extends Desktop_CPU {
	
	public Intel_i7_11700K_Desktop_CPU() {
		setName("11th Gen. Core i7 11700K");
		setBrand("Intel");
		setCoreCount(8);
		setSupportsHyperthreading(true);
		setFrequency("3.60 GHz");
		setMaxFrequency("5.00 GHz");
		setL1Cache("80 KB/Core");
		setL2Cache("512KB/Core");
		setL3Cache("16 MB");
	} 
}