package designPatterns.creational.abstractFactory.example_2;

public class Samsung_870QVO_1TB_SSD extends Storage {

	public Samsung_870QVO_1TB_SSD() {
		brand = StorageBrand.Samsung;
		name = "870QVO";
		capacity = "1 TB";
		type = StorageType.SATA_SSD;
		readSpeed = "560 MB/s";
		writeSpeed = "530 MB/s";
	}
	
}
