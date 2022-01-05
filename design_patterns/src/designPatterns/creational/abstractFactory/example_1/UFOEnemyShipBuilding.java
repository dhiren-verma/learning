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

	@Override
	protected EnemyShip makeEnemyShip(EnemyShipType typeOfShip) {
		EnemyShip theEnemyShip = null;
		
		// If UFO was sent grab the factory that knows what
		//types of weapons and engines a regular UFO needs.
		//The EnemyShip object is returned & given a name:
		if (typeOfShip==EnemyShipType.UFO) {
			EnemyShipFactory shipPartsFactory = new UFOEnemyShipFactory();
			theEnemyShip = new UFOEnemyShip(shipPartsFactory);
			theEnemyShip.setName("UFO Grunt Ship");
		} else
		// If UFO BOSS was sent grab the factory that knows
        // what types of weapons and engines a Boss UFO needs.
		//The EnemyShip object is returned & given a name:
		if (typeOfShip==EnemyShipType.BOSS_UFO) {
			EnemyShipFactory shipPartsFactory = new BossUFOEnemyShipFactory();
			theEnemyShip = new BossUFOEnemyShip(shipPartsFactory);
			theEnemyShip.setName("UFO BOSS Ship");
		}

		System.out.println("\nEnemy Ship Constructed:");
		
		return theEnemyShip;
	}

}
