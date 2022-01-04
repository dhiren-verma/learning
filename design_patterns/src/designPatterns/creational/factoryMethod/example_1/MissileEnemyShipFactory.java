package designPatterns.creational.factoryMethod.example_1;

/**
 * Represents Concrete Creator:
 * 
 * @author Dhirendra Verma
 */
public class MissileEnemyShipFactory extends EnemyShipFactory {
	
	@Override
	public EnemyShip makeEnemyShip() {
		return new MissileEnemyShip();
	}
	
}