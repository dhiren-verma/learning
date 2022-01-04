package designPatterns.creational.factoryMethod.example_1;

/**
 * Here the EnemyShipFactory delegates the responsibility of creating different
 * Types of Product Objects to its Subclasses, this approach is proper Factory
 * Method Pattern.
 * 
 * @author Dhirendra Verma
 */
public class EnemyShipTesting {
	
	public static void main(String[] args) {
		//Just by changing the ConcreteCreator we can change the Type of Product
		//that we get out of it:
//		EnemyShipFactory enemyShipFactory = new MissileEnemyShipFactory();
//		EnemyShipFactory enemyShipFactory = new UFOEnemyShipFactory();
		EnemyShipFactory enemyShipFactory = new BigUFOEnemyShipFactory();
		
		EnemyShip enemyShip = enemyShipFactory.makeEnemyShip();
		
		doStuff(enemyShip);
	}
	
	private static void doStuff(EnemyShip anEnemyShip) {
		anEnemyShip.displayEnemyShip();
		anEnemyShip.followHeroShip();
		anEnemyShip.enemyShipShoots();
	}

}
