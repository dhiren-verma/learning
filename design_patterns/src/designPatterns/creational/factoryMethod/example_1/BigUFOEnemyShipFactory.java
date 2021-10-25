package designPatterns.creational.factoryMethod.example_1;

public class BigUFOEnemyShipFactory extends EnemyShipFactory {
	
	@Override
	public EnemyShip makeEnemyShip() {
		return new BigUFOEnemyShip();
	}
	
}