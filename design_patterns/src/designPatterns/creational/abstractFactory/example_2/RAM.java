package designPatterns.creational.abstractFactory.example_2;

abstract class RAM {
	
	RAMBrand brand;
	String name;
	String frequency;
	String ramType;
	String casLatency;
	RAM_Channel channel;
	ComponentClass componentClass;
	String capacity;
	int stickCount;
	String singleStickCapacity;
	
	public String getBrand() {
		return brand.name();
	}
	
	public String getName() {
		return name;
	}

	public String getFrequency() {
		return frequency;
	}
	
	public String getRamType() {
		return ramType;
	}

	public String getCasLatency() {
		return casLatency;
	}

	public RAM_Channel getChannel() {
		return channel;
	}
	
	public ComponentClass getComponentClass() {
		return componentClass;
	}

	public String getCapacity() {
		return capacity;
	}
	
	public int getStickCount() {
		return stickCount;
	}
	
	public String getSingleStickCapacity() {
		return singleStickCapacity;
	}
	
	@Override
	public String toString() {
		StringBuilder ramDesc = new StringBuilder("\t");
		
		ramDesc.append(brand.name()).append(" ");
		ramDesc.append(name).append(" ");
		ramDesc.append(frequency).append(" ");
		ramDesc.append(ramType).append(" ");
		ramDesc.append("CL").append(casLatency).append(" ");
		ramDesc.append(channel.name()).append(" Channel ");
		ramDesc.append(((componentClass == ComponentClass.Desktop)?"DIMM ":"SoDIMM "));
		ramDesc.append(capacity).append(" Kit(");
		ramDesc.append(stickCount).append(" x ");
		ramDesc.append(singleStickCapacity).append(")\n");
		
		return ramDesc.toString();
	}
	
}
