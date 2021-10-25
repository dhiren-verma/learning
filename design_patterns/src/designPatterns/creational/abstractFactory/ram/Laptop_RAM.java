package designPatterns.creational.abstractFactory.ram;

public class Laptop_RAM extends RAM {
	
	@Override
	public String toString() {
		return "[" + name + " " + channel.name() + " Channel " + ramType + " SODIMM RAM,\n"
				+ "Capacity: " + capacity + " StickCount: " + stickCount + "\n"
				+ "Single Stick Capacity: " + singleStickCapacity + "\n"
				+ "Frequency: " + frequency + ", CAS Latency: " + casLatency + ", Ecc: " + isEcc + "]";
	}
	
}