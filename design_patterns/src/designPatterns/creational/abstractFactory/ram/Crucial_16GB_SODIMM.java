package designPatterns.creational.abstractFactory.ram;

public class Crucial_16GB_SODIMM extends Laptop_RAM {
	
	public Crucial_16GB_SODIMM() {
		setName("Crucial 16GB");
		setRamType("DDR4");
		setChannel(Channel.Dual);
		setStickCount(2);
		setEcc(false);
		setFrequency("3200MHz");
		setCasLatency("22");
		setSingleStickCapacity("8 GB");
		setCapacity("16 GB");
	}
	
}