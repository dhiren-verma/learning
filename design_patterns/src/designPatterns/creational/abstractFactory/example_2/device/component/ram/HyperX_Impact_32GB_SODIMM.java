package designPatterns.creational.abstractFactory.example_2.device.component.ram;

import designPatterns.creational.abstractFactory.example_2.device.component.ComponentClass;

public class HyperX_Impact_32GB_SODIMM extends RAM {

	public HyperX_Impact_32GB_SODIMM() {
		brand = RAMBrand.HyperX;
		name = "Impact 32GB";
		frequency = "3200 MHz";
		ramType = "DDR4";
		casLatency = "20";
		channel = RAM_Channel.Dual;
		componentClass = ComponentClass.Mobile;
		capacity = "32 GB";
		stickCount = 2;
		singleStickCapacity = "16 GB";
	}
	
}
