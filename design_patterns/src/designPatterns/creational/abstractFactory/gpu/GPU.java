package designPatterns.creational.abstractFactory.gpu;

import designPatterns.creational.abstractFactory.common.CpuGpuType;

public abstract class GPU {
	
	String name;
	String brand;
	CpuGpuType gpuType;
	int gpuCoreCount;
	int tensorCoreCount;
	int rtCoreCount;
	String memoryType;
	String memoryCapacity;
	String frequency;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public CpuGpuType getGpuType() {
		return gpuType;
	}
	
	public void setGpuType(CpuGpuType gpuType) {
		this.gpuType = gpuType;
	}
	
	public int getGPUCoreCount() {
		return gpuCoreCount;
	}
	
	public void setGPUCoreCount(int gpuCoreCount) {
		this.gpuCoreCount = gpuCoreCount;
	}
	
	public int getTensorCoreCount() {
		return tensorCoreCount;
	}
	
	public void setTensorCoreCount(int tensorCoreCount) {
		this.tensorCoreCount = tensorCoreCount;
	}

	public int getRTCoreCount() {
		return rtCoreCount;
	}
	
	public void setRTCoreCount(int rtCoreCount) {
		this.rtCoreCount = rtCoreCount;
	}
	
	public String getMemoryType() {
		return memoryType;
	}
	
	public void setMemoryType(String memoryType) {
		this.memoryType = memoryType;
	}
	
	public String getMemoryCapacity() {
		return memoryCapacity;
	}
	
	public void setMemoryCapacity(String memoryCapacity) {
		this.memoryCapacity = memoryCapacity;
	}
	
	public String getFrequency() {
		return frequency;
	}
	
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	@Override
	public String toString() {
		return "[" + brand + " " + name + " " + gpuType.name() + ",\n"
				+ "Cuda Core Count: " + gpuCoreCount + ", Tensor Core Count: " + tensorCoreCount + ",\n"
				+ "Memory: " + memoryCapacity + " " + memoryType + ", Base Freq: " + frequency + "]";
	}
	
}