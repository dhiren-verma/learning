package designPatterns.creational.abstractFactory.storage;

public class CrucialP5_NVME_SSD extends Storage{
	
	public CrucialP5_NVME_SSD() {
		setName("Crucial P5");
		setStorageType(StorageType.NVME_SSD);
		setCapacity("1 TB");
		setReadSpeed("6600 MB/s");
		setWriteSpeed("5400 MB/s");
	}
	
}