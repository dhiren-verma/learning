package designPatterns.creational.abstractFactory.gpu;

import designPatterns.creational.abstractFactory.common.CpuGpuType;

public class Mobile_GPU extends GPU {
	
	public Mobile_GPU() {
		setGpuType(CpuGpuType.Mobile);
		setBrand("");
	}
	
}