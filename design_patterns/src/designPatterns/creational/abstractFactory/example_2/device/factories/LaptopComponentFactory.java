package designPatterns.creational.abstractFactory.example_2.device.factories;

import designPatterns.creational.abstractFactory.example_2.device.component.cpu.AMD_Ryzen7_5800HS_Mobile_CPU;
import designPatterns.creational.abstractFactory.example_2.device.component.cpu.CPU;
import designPatterns.creational.abstractFactory.example_2.device.component.cpu.CPUBrand;
import designPatterns.creational.abstractFactory.example_2.device.component.cpu.Intel_i7_11800H_Mobile_CPU;
import designPatterns.creational.abstractFactory.example_2.device.component.gpu.GPU;
import designPatterns.creational.abstractFactory.example_2.device.component.gpu.GPUBrand;
import designPatterns.creational.abstractFactory.example_2.device.component.gpu.Nvidia_RTX_3080Ti_Mobile;
import designPatterns.creational.abstractFactory.example_2.device.component.gpu.Radeon_RX6800M_Mobile;
import designPatterns.creational.abstractFactory.example_2.device.component.ram.Crucial_Value_16GB_SODIMM;
import designPatterns.creational.abstractFactory.example_2.device.component.ram.HyperX_Impact_32GB_SODIMM;
import designPatterns.creational.abstractFactory.example_2.device.component.ram.RAM;
import designPatterns.creational.abstractFactory.example_2.device.component.ram.RAMBrand;

public class LaptopComponentFactory implements ComponentFactory {

	@Override
	public CPU getCPU(CPUBrand brand) {
		CPU cpu = null;
		
		switch (brand) {
			case AMD:
				cpu = new AMD_Ryzen7_5800HS_Mobile_CPU();
				break;
			case Intel:
				cpu = new Intel_i7_11800H_Mobile_CPU();
				break;
		}
		
		return cpu;
	}

	@Override
	public RAM getRam(RAMBrand brand) {
		RAM ram = null;
		
		switch (brand) {
			case Crucial:
				ram = new Crucial_Value_16GB_SODIMM();
				break;
			case HyperX:
				ram = new HyperX_Impact_32GB_SODIMM();
				break;
		}
		
		return ram;
	}

	@Override
	public GPU getGpu(GPUBrand brand) {
		GPU gpu = null;
		
		switch (brand) {
			case Nvidia:
				gpu = new Nvidia_RTX_3080Ti_Mobile();
				break;
			case Radeon:
				gpu = new Radeon_RX6800M_Mobile();
				break;
		}
		
		return gpu;
	}

}
