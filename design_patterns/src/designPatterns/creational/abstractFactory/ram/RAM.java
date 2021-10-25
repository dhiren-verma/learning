package designPatterns.creational.abstractFactory.ram;

public abstract class RAM {
	
	String name;
	String ramType;
	Channel channel;
	int stickCount;
	boolean isEcc;
	String frequency;
	String casLatency;
	String singleStickCapacity;
	String capacity;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRamType() {
		return ramType;
	}
	
	public void setRamType(String ramType) {
		this.ramType = ramType;
	}
	
	public Channel getChannel() {
		return channel;
	}
	
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	public int getStickCount() {
		return stickCount;
	}
	
	public void setStickCount(int stickCount) {
		this.stickCount = stickCount;
	}
	
	public boolean isEcc() {
		return isEcc;
	}
	
	public void setEcc(boolean isEcc) {
		this.isEcc = isEcc;
	}
	
	public String getFrequency() {
		return frequency;
	}
	
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	public String getCasLatency() {
		return casLatency;
	}
	
	public void setCasLatency(String casLatency) {
		this.casLatency = casLatency;
	}
	
	public String getSingleStickCapacity() {
		return singleStickCapacity;
	}
	
	public void setSingleStickCapacity(String singleStickCapacity) {
		this.singleStickCapacity = singleStickCapacity;
	}
	
	public String getCapacity() {
		return capacity;
	}
	
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
}