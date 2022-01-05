package designPatterns.creational.abstractFactory.example_2;

import designPatterns.creational.abstractFactory.example_2.device.Computer;
import designPatterns.creational.abstractFactory.example_2.device.factories.ComputerFactory;
import designPatterns.creational.abstractFactory.example_2.device.factories.ManufacturerType;

public class RetailerShop {

	//System inside is most abstracted from Client & he's only exposed to details that he must know,
	//For example, when ordering a Computer, User/Retailer(User's Proxy) knows if he wants a Desktop
	//Computer or a LAptop Computer, also he knows what Brand he wants & these are the only Details
	//collected from Client:
	public static void main(String[] args) {
		ComputerFactory desktopFactory = new AbstractDeviceFactory().getComputerFactory(ComputerType.Desktop);
		
		Computer firstClientComputer = desktopFactory.orderComputer(ManufacturerType.CyberPower);
		
		System.out.println("First Client's Computer:");
		printSystemSpecs(firstClientComputer);
		
		Computer secondClientComputer = desktopFactory.orderComputer(ManufacturerType.Dell);
		
		System.out.println("\n\nSecond Client's Computer:");
		printSystemSpecs(secondClientComputer);
		
		
		ComputerFactory laptopFactory = new AbstractDeviceFactory().getComputerFactory(ComputerType.Laptop);
		
		Computer thirdClientComputer = laptopFactory.orderComputer(ManufacturerType.Asus);
		
		System.out.println("\n\nThird Client's Computer:");
		printSystemSpecs(thirdClientComputer);
		
		Computer fourthClientComputer = laptopFactory.orderComputer(ManufacturerType.MSI);
		
		System.out.println("\n\nFourth Client's Computer:");
		printSystemSpecs(fourthClientComputer);
		
	}

	private static void printSystemSpecs(Computer myComputer) {
		if (myComputer!=null) {
			System.out.println();
			System.out.println(myComputer.displayComputerSpecs());
		} else {
			System.out.println("There isn't a Computer available for your specified Filters");
		}
	}

}
