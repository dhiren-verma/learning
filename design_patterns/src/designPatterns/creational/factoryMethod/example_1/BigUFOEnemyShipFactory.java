package designPatterns.creational.factoryMethod.example_1;

/**
 * Represents Concrete Creator:
 * 
 * @author Dhirendra Verma
 */
public class BigUFOEnemyShipFactory extends EnemyShipFactory {
	
	@Override
	public EnemyShip makeEnemyShip() {
		return new BigUFOEnemyShip();
	}
	
}