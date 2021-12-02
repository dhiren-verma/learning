package designPatterns.creational.abstractFactory.example_2;

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
