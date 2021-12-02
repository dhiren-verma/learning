package designPatterns.creational.abstractFactory.example_2;

public class AMD_Ryzen7_5800HS_Mobile_CPU extends CPU {

	public AMD_Ryzen7_5800HS_Mobile_CPU() {
		brand = CPUBrand.AMD;
		name = "5th Gen. Ryzen7 5800HS";
		componentClass = ComponentClass.Mobile;
		coreCount = 8;
		supportsHyperthreading = true;
		pcieVersion = "3.0";
		frequency = "2.80 GHz";
		turboFrequency = "4.40 GHz";
		l1Cache = "512 KB";
		l2Cache = "4 MB";
		l3Cache = "16 MB";
	}
}
