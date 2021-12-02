package designPatterns.creational.abstractFactory.example_2;

public class Crucial_Ballistix_32GB_DIMM extends RAM {

	public Crucial_Ballistix_32GB_DIMM() {
		brand = RAMBrand.Crucial;
		name = "Ballistix";
		frequency = "3200 MHz";
		ramType = "DDR4";
		casLatency = "16";
		channel = RAM_Channel.Dual;
		componentClass = ComponentClass.Desktop;
		capacity = "32 GB";
		stickCount = 2;
		singleStickCapacity = "16 GB";
	}
	
}
