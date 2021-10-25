package designPatterns.creational.abstractFactory;

import designPatterns.creational.abstractFactory.computer.Computer;

public class Test {

	public static void main(String[] args) {
		Computer asusLaptop = ComputerFactory.getComputer(new AsusLaptopFactory());
		Computer msiLaptop = ComputerFactory.getComputer(new MSILaptopFactory());
		Computer cyberPowerDesktop = ComputerFactory.getComputer(new CyberPowerDesktopFactory());
		Computer dellDesktop = ComputerFactory.getComputer(new DellDesktopFactory());
		
		System.out.println(asusLaptop);
		System.out.println("\n\n");
		System.out.println(msiLaptop);
		System.out.println("\n\n");
		System.out.println(cyberPowerDesktop);
		System.out.println("\n\n");
		System.out.println(dellDesktop);
		
	}

}
