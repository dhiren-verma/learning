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
public class UFOEnemyShip extends EnemyShip {
	
	private EnemyShipFactory shipFactory;
	
	public UFOEnemyShip(EnemyShipFactory shipFactory) {
		this.shipFactory = shipFactory;
	}
	
	@Override
	public void makeShip() {
		System.out.println("Making Enemy Ship: " + getName());
		
		weapon = shipFactory.addESWeapon();
		engine = shipFactory.addESEngine();
	}

}
