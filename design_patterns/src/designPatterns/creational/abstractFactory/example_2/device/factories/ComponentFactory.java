package designPatterns.creational.abstractFactory.example_2.device.factories;

import designPatterns.creational.abstractFactory.example_2.device.component.cpu.CPU;
import designPatterns.creational.abstractFactory.example_2.device.component.cpu.CPUBrand;
import designPatterns.creational.abstractFactory.example_2.device.component.gpu.GPU;
import designPatterns.creational.abstractFactory.example_2.device.component.gpu.GPUBrand;
import designPatterns.creational.abstractFactory.example_2.device.component.ram.RAM;
import designPatterns.creational.abstractFactory.example_2.device.component.ram.RAMBrand;
import designPatterns.creational.abstractFactory.example_2.device.componentstorage.Crucial_P5_1TD_NVMe_SSD;
import designPatterns.creational.abstractFactory.example_2.device.componentstorage.Samsung_870QVO_1TB_SSD;
import designPatterns.creational.abstractFactory.example_2.device.componentstorage.Storage;
import designPatterns.creational.abstractFactory.example_2.device.componentstorage.StorageBrand;

public interface ComponentFactory {
	
	CPU getCPU(CPUBrand brand);
	RAM getRam(RAMBrand brand);
	GPU getGpu(GPUBrand brand);
	
	default Storage getStorage(StorageBrand brand) {
		Storage storage = null;
		
		switch (brand) {
			case Crucial:
				storage = new Crucial_P5_1TD_NVMe_SSD();
				break;
			case Samsung:
				storage = new Samsung_870QVO_1TB_SSD();
				break;
		}
		
		return storage;
	}

}
