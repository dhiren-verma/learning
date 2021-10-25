package designPatterns.creational.abstractFactory.storage;

public class Seagate_BarraCuda extends Storage{
	
	public Seagate_BarraCuda() {
		setName("Seagate BarraCuda");
		setStorageType(StorageType.HDD);
		setCapacity("1 TB");
		setReadSpeed("210 MB/s");
		setWriteSpeed("26.25 MB/s");
	}
	
}