package designPatterns.creational.factoryMethod.example_1;

public class MissileEnemyShipFactory extends EnemyShipFactory {
	
	@Override
	public EnemyShip makeEnemyShip() {
		return new MissileEnemyShip();
	}
	
}