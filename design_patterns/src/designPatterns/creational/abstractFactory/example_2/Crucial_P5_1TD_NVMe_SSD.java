package designPatterns.creational.abstractFactory.example_2;

public class Crucial_P5_1TD_NVMe_SSD extends Storage {

	public Crucial_P5_1TD_NVMe_SSD() {
		brand = StorageBrand.Crucial;
		name = "P5";
		capacity = "1TB";
		type = StorageType.NVMe_SSD;
		readSpeed = "6600 MB/s";
		writeSpeed = "5400 MB/s";
	}
	
}
