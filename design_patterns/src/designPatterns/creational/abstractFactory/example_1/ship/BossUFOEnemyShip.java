package designPatterns.creational.abstractFactory.example_1.ship;

import designPatterns.creational.abstractFactory.example_1.ship.factories.EnemyShipFactory;

/**
 * Represents one of the Concrete Product that Client
 * receives from the Abstract Factory
 * 
 * Uses Strategy Pattern for the Components
 * 
 * @author Dhirendra Verma
 */
public class BossUFOEnemyShip extends EnemyShip {

	private EnemyShipFactory shipFactory;
	
	public BossUFOEnemyShip(EnemyShipFactory shipFactory) {
		this.shipFactory = shipFactory;
	}
	
	@Override
	public void makeShip() {
		System.out.println("Making Enemy Ship: " + getName());
		
		weapon = shipFactory.addESWeapon();
		engine = shipFactory.addESEngine();
	}

}
