package designPatterns.creational.abstractFactory.example_1.ship.engine;

/**
 * Represents Concrete Product Class for one of the Products
 * 
 * Strategy Design Pattern is being used here, as we can vary
 * ESEngine Implementations dynamically
 * 
 * @author Dhirendra Verma
 */
public class ESBossUFOEngine implements ESEngine {

	@Override
	public String getSpeed() {
		return "2,000 mph";
	}

}
