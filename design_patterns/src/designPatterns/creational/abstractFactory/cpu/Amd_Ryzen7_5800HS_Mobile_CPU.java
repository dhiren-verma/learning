package designPatterns.creational.abstractFactory.cpu;

public class Amd_Ryzen7_5800HS_Mobile_CPU extends Laptop_CPU {
	
	public Amd_Ryzen7_5800HS_Mobile_CPU() {
		setName("5th Gen. Ryzen7 5800HS");
		setBrand("AMD");
		setCoreCount(8);
		setSupportsHyperthreading(true);
		setFrequency("1.90 GHz");
		setMaxFrequency("4.40 GHz");
		setL1Cache("");
		setL2Cache("4 MB");
		setL3Cache("16 MB");
	}
	
}
