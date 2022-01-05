package designPatterns.creational.abstractFactory.example_1.ship.weapon;

/**
 * Represents Interface/Abstract Class for one for the Products
 * 
 * Any Component/Class that implements this Interface
 * can take place of this Interface in Enemy Ship.
 * 
 * @author Dhirendra Verma
 *
 */
public interface ESWeapon {
	
	public String getDamage();
	
}
