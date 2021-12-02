package designPatterns.creational.abstractFactory.example_1;

// This is the only class that needs to change, if you
// want to determine which enemy ships you want to
// provide as an option to build
public class UFOEnemyShipBuilding extends EnemyShipBuilding {

	@Override
	protected EnemyShip makeEnemyShip(String typeOfShip) {
		EnemyShip theEnemyShip = null;
		
		// If UFO was sent grab use the factory that knows
        // what types of weapons and engines a regular UFO
        // needs. The EnemyShip object is returned & given a name
		if (typeOfShip.equals("UFO")) {
			EnemyShipFactory shipPartsFactory = new UFOEnemyShipFactory();
			theEnemyShip = new UFOEnemyShip(shipPartsFactory);
			theEnemyShip.setName("UFO Grunt Ship");
		} else
		// If UFO BOSS was sent grab use the factory that knows
        // what types of weapons and engines a Boss UFO
        // needs. The EnemyShip object is returned & given a name
			if (typeOfShip.equals("BOSS UFO")) {
			EnemyShipFactory shipPartsFactory = new BossUFOEnemyShipFactory();
			theEnemyShip = new BossUFOEnemyShip(shipPartsFactory);
			theEnemyShip.setName("UFO BOSS Ship");
		}

		return theEnemyShip;
	}

}
