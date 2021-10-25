package designPatterns.creational.abstractFactory.storage;

public abstract class Storage {
	
	private String name;
	private StorageType type;
	private String capacity;
	private String readSpeed;
	private String writeSpeed;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setStorageType(StorageType type) {
		this.type = type;
	}
	
	public StorageType getStorageType() {
		return type;
	}
	
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
	public String getStorageCapacity() {
		return capacity;
	}
	
	public void setReadSpeed(String readSpeed) {
		this.readSpeed = readSpeed;
	}
	
	public String getReadSpeed() {
		return readSpeed;
	}
	
	public void setWriteSpeed(String writeSpeed) {
		this.writeSpeed = writeSpeed;
	}
	
	public String getWriteSpeed() {
		return writeSpeed;
	}
	
	@Override
	public String toString() {
		return "[" + name + ", Type: " + type + ",\n" +
				"Capacity: " + capacity + ", ReadSpeed: " + readSpeed + ", WriteSpeed: " + writeSpeed + "]";
	}
	
}