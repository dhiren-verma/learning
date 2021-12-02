package designPatterns.creational.abstractFactory.example_2;

public class DesktopComponentFactory implements ComponentFactory {

	@Override
	public CPU getCPU(CPUBrand brand) {
		CPU cpu = null;
		
		switch (brand) {
			case AMD:
				cpu = new AMD_Ryzen7_5800X_Desktop_CPU();
				break;
			case Intel:
				cpu = new Intel_i7_11700K_Desktop_CPU();
				break;
		}
		
		return cpu;
	}

	@Override
	public RAM getRam(RAMBrand brand) {
		RAM ram = null;
		
		switch (brand) {
			case Crucial:
				ram = new Crucial_Ballistix_32GB_DIMM();
				break;
			case HyperX:
				ram = new HyperX_Fury_32GB_DIMM();
				break;
		}
		
		return ram;
	}

	@Override
	public GPU getGpu(GPUBrand brand) {
		GPU gpu = null;
		
		switch (brand) {
			case Nvidia:
				gpu = new EVGA_Nvidia_RTX_3080Ti();
				break;
			case Radeon:
				gpu = new Asus_Radeon_RX6800XT();
				break;
		}
		
		return gpu;
	}

}
