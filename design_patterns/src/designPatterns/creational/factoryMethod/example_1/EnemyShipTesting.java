package designPatterns.creational.factoryMethod.example_1;

public class EnemyShipTesting {

	public static void main(String[] args) {
		EnemyShipFactory enemyShipFactory = new MissileEnemyShipFactory();
		
		EnemyShip enemyShip = enemyShipFactory.makeEnemyShip();
		
		doStuff(enemyShip);
	}
	
	private static void doStuff(EnemyShip anEnemyShip) {
		anEnemyShip.displayEnemyShip();
		anEnemyShip.followHeroShip();
		anEnemyShip.enemyShipShoots();
	}

}
