package designPatterns.creational.abstractFactory.example_1.ship.engine;

/**
 * Represents Interface/Abstract Class for one of the Products
 * 
 * Any Component/Class that implements this Interface
 * can take place of this Interface in Enemy Ship.
 * 
 * @author Dhirendra Verma
 */
public interface ESEngine {
	
	public String getSpeed();
	
}
