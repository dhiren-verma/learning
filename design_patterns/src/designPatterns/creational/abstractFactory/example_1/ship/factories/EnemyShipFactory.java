package designPatterns.creational.abstractFactory.example_1.ship.factories;

import designPatterns.creational.abstractFactory.example_1.ship.engine.ESEngine;
import designPatterns.creational.abstractFactory.example_1.ship.weapon.ESWeapon;

/**
 * Represents Abstract Factory:
 * 
 * With an Abstract Factory Pattern you won't just
 * build ships, but also all of the components for
 * the ships.
 * 
 * Here is where you define the parts that are required
 * if an object wants to be an enemy ship
 * 
 * @author Dhirendra Verma
 */
public interface EnemyShipFactory {

	public ESWeapon addESWeapon();
	public ESEngine addESEngine();
	
}
