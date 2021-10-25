package designPatterns.creational.factoryMethod.example_1;

import java.util.Scanner;

public class SimpleEnemyShipTesting {
	
	public static void main(String[] args) {
		//Basic way, without using Factory Method Design Pattern:
		EnemyShip enemyShip = null;
		
		Scanner userInput = new Scanner(System.in);
		
		String enemyShipOption  = "";
		
		System.out.println("What type of Ship? ( U / M / B )");
		
		if (userInput.hasNextLine()) {
			enemyShipOption = userInput.nextLine();
		}
		
		userInput.close();
		
//		//Big sign that Factory Method Pattern is needed,
//		//as we are using Conditional blocks to decide which Subclass of EnemyShip to be Instantiated:
//		//Any-time we add a new Type of EnemyShip we need to update our Conditional Block to have the
//		//capability to instantiate that new type of EnemyShip that has been added:
//		if (enemyShipOption.equalsIgnoreCase("U")) {
//			enemyShip = new UFOEnemyShip();
//		} else if (enemyShipOption.equalsIgnoreCase("M")) {
//			enemyShip = new MissileEnemyShip();
//		} else if()enemyShipType.equalsIgnoreCase("B") {
//			enemyShip = new BigUFOEnemyShip();
//		}
		
		//Factory Method in action:
		SimpleEnemyShipFactory enemyShipFactory = new SimpleEnemyShipFactory();
		
		enemyShip = enemyShipFactory.makeEnemyShip(enemyShipOption);
		
		if (enemyShip!=null)
			doStuff(enemyShip);
		else
			System.out.println("Enter a 'U', 'M' or 'B' next time!");
		
	}
	
	private static void doStuff(EnemyShip anEnemyShip) {
		anEnemyShip.displayEnemyShip();
		anEnemyShip.followHeroShip();
		anEnemyShip.enemyShipShoots();
	}
	
}
