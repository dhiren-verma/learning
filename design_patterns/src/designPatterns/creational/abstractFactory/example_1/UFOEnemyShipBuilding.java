package designPatterns.creational.abstractFactory.example_1;

import designPatterns.creational.abstractFactory.example_1.ship.BossUFOEnemyShip;
import designPatterns.creational.abstractFactory.example_1.ship.EnemyShip;
import designPatterns.creational.abstractFactory.example_1.ship.UFOEnemyShip;
import designPatterns.creational.abstractFactory.example_1.ship.factories.BossUFOEnemyShipFactory;
import designPatterns.creational.abstractFactory.example_1.ship.factories.EnemyShipFactory;
import designPatterns.creational.abstractFactory.example_1.ship.factories.UFOEnemyShipFactory;

// This is the only class that needs to change, if you
// want to determine which enemy ships you want to
// provide as an option to build
public class UFOEnemyShipBuilding extends EnemyShipBuilding {

	private UFOEnemyShipBuilding() {}
	
	private static class SingletonHelperClass {
		private static final UFOEnemyShipBuilding INSTANCE =
				new UFOEnemyShipBuilding();
	}
	
	public static UFOEnemyShipBuilding getInstance() {
		return SingletonHelperClass.INSTANCE;
	}
	
	@Override
	protected EnemyShip makeEnemyShip(EnemyShipType typeOfShip) {
		EnemyShip theEnemyShip = null;
		EnemyShipFactory shipPartsFactory = null;
		
		switch (typeOfShip) {
			// If UFO was sent grab the factory that knows what
			//types of weapons and engines a regular UFO needs.
			//The EnemyShip object is returned & given a name:
			case UFO: 
				shipPartsFactory = UFOEnemyShipFactory.getInstance();
				theEnemyShip = new UFOEnemyShip(shipPartsFactory);
				theEnemyShip.setName("UFO Grunt Ship");
				break;
			// If UFO BOSS was sent grab the factory that knows
	        // what types of weapons and engines a Boss UFO needs.
			//The EnemyShip object is returned & given a name:
			case BOSS_UFO:
				shipPartsFactory = BossUFOEnemyShipFactory.getInstance();
				theEnemyShip = new BossUFOEnemyShip(shipPartsFactory);
				theEnemyShip.setName("UFO BOSS Ship");
				break;
		}
		
		System.out.println("\nEnemy Ship Constructed:");
		
		return theEnemyShip;
	}

}
