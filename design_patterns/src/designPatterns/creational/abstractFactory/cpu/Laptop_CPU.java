package designPatterns.creational.abstractFactory.cpu;

import designPatterns.creational.abstractFactory.common.CpuGpuType;

public class Laptop_CPU extends CPU {
	
	public Laptop_CPU() {
		setCpuType(CpuGpuType.Mobile);
	}
	
}