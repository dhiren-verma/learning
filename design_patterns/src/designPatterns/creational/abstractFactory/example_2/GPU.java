package designPatterns.creational.abstractFactory.example_2;

abstract class GPU {

	String secBrand;
	GPUBrand brand;
	String name;
	String memoryCapacity;
	String memoryType;
	ComponentClass componentClass;
	String frequency;
	int gpuCoreCount;
	int tensorCoreCount;
	int rtCoreCount;
	
	public String getSecBrand() {
		return secBrand;
	}
	
	public GPUBrand getBrand() {
		return brand;
	}

	public String getName() {
		return name;
	}

	public String getMemoryCapacity() {
		return memoryCapacity;
	}

	public String getMemoryType() {
		return memoryType;
	}

	public ComponentClass getComponentClass() {
		return componentClass;
	}

	public String getFrequency() {
		return frequency;
	}

	public int getGpuCoreCount() {
		return gpuCoreCount;
	}

	public int getTensorCoreCount() {
		return tensorCoreCount;
	}

	public int getRtCoreCount() {
		return rtCoreCount;
	}

	@Override
	public String toString() {
		StringBuilder gpuDesc = new StringBuilder("\t");
		
		if (!secBrand.isEmpty()) {
			gpuDesc.append(secBrand);
			gpuDesc.append(" ");
		}
		
		gpuDesc.append(brand.name()).append(" ");
		gpuDesc.append(name).append(" ");
		gpuDesc.append(memoryCapacity).append(" ");
		gpuDesc.append(memoryType).append(" ");
		gpuDesc.append(componentClass.name()).append(" Graphics Card,\n");
		gpuDesc.append("\tBase Freq: ").append(frequency).append(",\n");
		gpuDesc.append("\tGPU Core Count: ").append(gpuCoreCount).append("\n");
		gpuDesc.append("\tTensor Core Count: ").append(tensorCoreCount).append("\n");
		gpuDesc.append("\tRT Core Count: ").append(rtCoreCount).append("\n");
		
		return gpuDesc.toString();
	}
	
}
