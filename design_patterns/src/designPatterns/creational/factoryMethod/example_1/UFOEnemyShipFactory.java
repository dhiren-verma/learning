package designPatterns.creational.factoryMethod.example_1;

public class UFOEnemyShipFactory extends EnemyShipFactory {
	
	@Override
	public EnemyShip makeEnemyShip() {
		return new UFOEnemyShip();
	}
	
}