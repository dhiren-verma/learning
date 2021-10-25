package designPatterns.creational.abstractFactory.cpu;

import designPatterns.creational.abstractFactory.common.CpuGpuType;

public abstract class CPU {
	
	private String name;
	private String brand;
	private CpuGpuType cpuType;
	private int coreCount;
	private boolean supportsHyperthreading;
	private String frequency;
	private String maxFrequency;
	private String l1Cache;
	private String l2Cache;
	private String l3Cache;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setCpuType(CpuGpuType cpuType) {
		this.cpuType = cpuType;
	}
	
	public CpuGpuType getCpuType() {
		return cpuType;
	}
	
	public void setCoreCount(int coreCount) {
		this.coreCount = coreCount;
	}
	
	public int getCoreCount() {
		return coreCount;
	}
	
	public void setSupportsHyperthreading(boolean supportsHyperthreading) {
		this.supportsHyperthreading = supportsHyperthreading;
	}
	
	public boolean supportsHyperthreading() {
		return supportsHyperthreading;
	}
	
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	public String getFrequency() {
		return frequency;
	}
	
	public void setMaxFrequency(String maxFrequency) {
		this.maxFrequency = maxFrequency;
	}
	
	public String getMaxFrequency() {
		return maxFrequency;
	}
	
	public void setL1Cache(String l1Cache) {
		this.l1Cache = l1Cache;
	}
	
	public String getL1Cache() {
		return l1Cache;
	}

	public void setL2Cache(String l2Cache) {
		this.l2Cache = l2Cache;
	}
	
	public String getL2Cache() {
		return l2Cache;
	}
	
	public void setL3Cache(String l3Cache) {
		this.l3Cache = l3Cache;
	}
	
	public String getL3Cache() {
		return l3Cache;
	}

	@Override
	public String toString() {
		return "[" + brand + " " + name + " " + cpuType.name() + " CPU,\n" +
				"with Core Count: " + coreCount + " & Thread Count: " + (supportsHyperthreading?coreCount*2:coreCount) + ",\n" +
				"Base Freq: " + frequency + ", Turbo Freq: " + maxFrequency + ",\n" +
				"L1 Cache: " + l1Cache + ", L2 Cache: " + l2Cache + "& L3 Cache: " + l3Cache + "]";
	}
	
}