package designPatterns.creational.factoryMethod.example_1;

/**
 * Here the EnemyShipFactory itself takes the responsibility of creating all the
 * Types of Product Objects, this approach is called Simple Factory Method Pattern
 *  
 * A EnemyShipFactory which delegates Product Instantiation to its Subclass would
 * be a proper example of Complete Factory Pattern, Why?
 * Because in case a new Type of Product is added, still we will need to come back
 * to EnemyShipFactory and add one more Conditional Block to handle instantiation
 * of that new Type of Product, which is against Open-Closed Design Principle of
 * Object Oriented Programming.  
 * But if in case we delegate EnemyShip Instantiation to Subclasses, then a new
 * Factory Method Subclass can be used to instantiate new Type of Product.
 * 
 * @author Dhirendra Verma
 */
public class SimpleEnemyShipFactory {
	
	public EnemyShip makeEnemyShip(String newShipType) {
		EnemyShip newShip = null;
		
		if (newShipType.equalsIgnoreCase("U")) {
			newShip = new UFOEnemyShip();
		} else if (newShipType.equalsIgnoreCase("M")) {
			newShip = new MissileEnemyShip();
		} else if (newShipType.equalsIgnoreCase("B")) {
			newShip = new BigUFOEnemyShip();
		}
		
		return newShip;
	}
	
}
