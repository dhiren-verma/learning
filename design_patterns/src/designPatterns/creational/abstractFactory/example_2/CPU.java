package designPatterns.creational.abstractFactory.example_2;

abstract class CPU {
	
	CPUBrand brand;
	String name;
	ComponentClass componentClass;
	int coreCount;
	boolean supportsHyperthreading;
	String pcieVersion;
	String frequency;
	String turboFrequency;
	String l1Cache;
	String l2Cache;
	String l3Cache;
	
	public String getBrand() {
		return brand.name();
	}
	
	public String getName() {
		return name;
	}
	
	public ComponentClass getComponentClass() {
		return componentClass;
	}
	
	public int getCoreCount() {
		return coreCount;
	}
	
	public boolean supportsHyperthreading() {
		return supportsHyperthreading;
	}
	
	public String getPCIEVersion() {
		return pcieVersion;
	}
	
	public String getFrequency() {
		return frequency;
	}
	
	public String getTurboFrequency() {
		return turboFrequency;
	}
	
	public String getL1Cache() {
		return l1Cache;
	}
	
	public String getL2Cache() {
		return l2Cache;
	}
	
	public String getL3Cache() {
		return l3Cache;
	}

	@Override
	public String toString() {
		StringBuilder cpuDesc = new StringBuilder("\t");
		
		cpuDesc.append(brand.name()).append(" ");
		cpuDesc.append(name).append(" ");
		cpuDesc.append(componentClass.name()).append(" CPU,\n");
		cpuDesc.append("\t").append(coreCount).append(" Core, ");
		cpuDesc.append((supportsHyperthreading?coreCount*2:coreCount)).append(" Threads,\n");
		cpuDesc.append("\tPCIE Version: ").append(pcieVersion).append(",\n");
		cpuDesc.append("\tBase Freq: ").append(frequency).append(", ");
		cpuDesc.append("Turbo Freq: ").append(turboFrequency).append(",\n");
		cpuDesc.append("\tL1 Cache: ").append(l1Cache).append(", ");
		cpuDesc.append("L2 Cache: ").append(l2Cache).append(", ");
		cpuDesc.append("L3 Cache: ").append(l3Cache).append(("\n"));
		
		return cpuDesc.toString();
	}
	
}
