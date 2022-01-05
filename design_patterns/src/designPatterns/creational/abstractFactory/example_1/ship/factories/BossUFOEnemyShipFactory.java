package designPatterns.creational.abstractFactory.example_1.ship.factories;

import designPatterns.creational.abstractFactory.example_1.ship.engine.ESBossUFOEngine;
import designPatterns.creational.abstractFactory.example_1.ship.engine.ESEngine;
import designPatterns.creational.abstractFactory.example_1.ship.weapon.ESBossUFOWeapon;
import designPatterns.creational.abstractFactory.example_1.ship.weapon.ESWeapon;

/**
 * Represents Concrete Factory
 * 
 * This Concrete Factory uses the EnemyShipFactory
 * interface to create very specific UFO Enemy Ship.
 * 
 * This is where we define all of the parts the ship
 * will use by defining the methods implemented
 * being ESWeapon and ESEngine
 * 
 * The returned object specifies a specific weapon &
 * engine
 * 
 * @author Dhirendra Verma
 *
 */
public class BossUFOEnemyShipFactory implements EnemyShipFactory {

	private BossUFOEnemyShipFactory() {}
	
	private static class SingletonHelperClass {
		private static final BossUFOEnemyShipFactory INSTANCE =
				new BossUFOEnemyShipFactory();
	}
	
	public static BossUFOEnemyShipFactory getInstance() {
		return SingletonHelperClass.INSTANCE;
	}
	
	// Defines the weapon object to associate with the ship
	@Override
	public ESWeapon addESWeapon() {
		return new ESBossUFOWeapon();
	}

	// Defines the engine object to associate with the ship
	@Override
	public ESEngine addESEngine() {
		return new ESBossUFOEngine();
	}

}
