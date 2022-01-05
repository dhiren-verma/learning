package designPatterns.creational.abstractFactory.example_1.ship.weapon;

/**
 * Represents Concrete Product Class for one of the Products
 * 
 * Strategy Design Pattern is being used here, as we can vary
 * ESWeapon Implementations dynamically
 * 
 * @author Dhirendra Verma
 */
public class ESUFOWeapon implements ESWeapon {
	
	@Override
	public String getDamage() {
		return "20";
	}
	
}