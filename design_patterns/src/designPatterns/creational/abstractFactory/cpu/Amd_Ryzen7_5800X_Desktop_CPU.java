package designPatterns.creational.abstractFactory.cpu;

public class Amd_Ryzen7_5800X_Desktop_CPU extends Desktop_CPU {
	
	public Amd_Ryzen7_5800X_Desktop_CPU() {
		setName("5th Gen. Ryzen7 5800X");
		setBrand("AMD");
		setCoreCount(8);
		setSupportsHyperthreading(true);
		setFrequency("3.80 GHz");
		setMaxFrequency("4.70 GHz");
		setL1Cache("");
		setL2Cache("4 MB");
		setL3Cache("32 MB");
	}
	
}
