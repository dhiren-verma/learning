package designPatterns.creational.abstractFactory.cpu;

public class Intel_i7_11800H_Mobile_CPU extends Laptop_CPU {
	
	public Intel_i7_11800H_Mobile_CPU() {
		setName("11th Gen. Core i7 11800H");
		setBrand("Intel");
		setCoreCount(8);
		setSupportsHyperthreading(true);
		setFrequency("2.30 GHz");
		setMaxFrequency("4.60 GHz");
		setL1Cache("80 KB/Core");
		setL2Cache("1250KB/Core");
		setL3Cache("24 MB");
	} 
}