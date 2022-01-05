package designPatterns.creational.abstractFactory.example_1.ship.factories;

import designPatterns.creational.abstractFactory.example_1.ship.engine.ESEngine;
import designPatterns.creational.abstractFactory.example_1.ship.engine.ESUFOEngine;
import designPatterns.creational.abstractFactory.example_1.ship.weapon.ESUFOWeapon;
import designPatterns.creational.abstractFactory.example_1.ship.weapon.ESWeapon;

/**
 * Represents Concrete Factory:
 * 
 * This factory uses the EnemyShipFactory interface
 * to create very specific UFO Enemy Ship
 * 
 * This is where we define all of the parts the ship
 * will use by defining the methods implemented
 * being ESWeapon and ESEngine
 * 
 * The returned object specifies a specific weapon & engine
 * 
 * @author Dhirendra Verma
 */
public class UFOEnemyShipFactory implements EnemyShipFactory {

	// Defines the weapon object to associate with the ship
	@Override
	public ESWeapon addESWeapon() {
		return new ESUFOWeapon();	//Specific to Regular UFO
	}

	// Defines the engine object to associate with the ship
	@Override
	public ESEngine addESEngine() {
		return new ESUFOEngine();	//Specific to regular UFO
	}

}
