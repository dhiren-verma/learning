package designPatterns.creational.abstractFactory.example_2;

public class Crucial_Value_16GB_SODIMM extends RAM {
	
	public Crucial_Value_16GB_SODIMM() {
		brand = RAMBrand.Crucial;
		name = "Value 16GB";
		frequency = "3200 MHz";
		ramType = "DDR4";
		casLatency = "22";
		channel = RAM_Channel.Dual;
		componentClass = ComponentClass.Mobile;
		capacity = "16 GB";
		stickCount = 2;
		singleStickCapacity = "8 GB";
	}
	
}
