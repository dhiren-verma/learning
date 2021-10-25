package designPatterns.creational.abstractFactory.gpu;

import designPatterns.creational.abstractFactory.common.CpuGpuType;

public class Desktop_GPU extends GPU {
	
	public Desktop_GPU() {
		setGpuType(CpuGpuType.Desktop);
	}
	
}