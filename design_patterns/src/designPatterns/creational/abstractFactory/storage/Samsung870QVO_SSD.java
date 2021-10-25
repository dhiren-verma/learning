package designPatterns.creational.abstractFactory.storage;

public class Samsung870QVO_SSD extends Storage{
	
	public Samsung870QVO_SSD() {
		setName("Samsung 870QVO");
		setStorageType(StorageType.SATA_SSD);
		setCapacity("1 TB");
		setReadSpeed("560 MB/s");
		setWriteSpeed("530 MB/s");
	}
	
}