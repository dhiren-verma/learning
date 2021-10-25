package designPatterns.creational.abstractFactory.cpu;

import designPatterns.creational.abstractFactory.common.CpuGpuType;

public class Desktop_CPU extends CPU {
	
	public Desktop_CPU() {
		setCpuType(CpuGpuType.Desktop);
	}
	
}
