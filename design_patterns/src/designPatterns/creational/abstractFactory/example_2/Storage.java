package designPatterns.creational.abstractFactory.example_2;

public abstract class Storage {

	StorageBrand brand;
	String name;
	String capacity;
	StorageType type;
	String readSpeed;
	String writeSpeed;
	
	public StorageBrand getBrand() {
		return brand;
	}
	
	public String getName() {
		return name;
	}

	public String getCapacity() {
		return capacity;
	}
	
	public StorageType getType() {
		return type;
	}
	
	public String getReadSpeed() {
		return readSpeed;
	}
	
	public String getWriteSpeed() {
		return writeSpeed;
	}

	@Override
	public String toString() {
		StringBuilder storageDesc = new StringBuilder(brand.name());
		
		storageDesc.append(" ");
		storageDesc.append(name).append(" ");
		storageDesc.append(capacity).append(" ");
		storageDesc.append(type.name()).append(" ");
		storageDesc.append("upto ").append(readSpeed).append("Read Speed & ");
		storageDesc.append("upto ").append(writeSpeed).append(" Write Speed\n");
		
		return storageDesc.toString();
	}
	
}
