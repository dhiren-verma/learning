package designPatterns.creational.abstractFactory.ram;

public class Crucial_Ballistix_32GB extends Desktop_RAM {
	
	public Crucial_Ballistix_32GB() {
		setName("Crucial Ballistix 32GB");
		setRamType("DDR4");
		setChannel(Channel.Dual);
		setStickCount(2);
		setEcc(false);
		setFrequency("3200MHz");
		setCasLatency("16");
		setSingleStickCapacity("16 GB");
		setCapacity("32 GB");
	}
	
}