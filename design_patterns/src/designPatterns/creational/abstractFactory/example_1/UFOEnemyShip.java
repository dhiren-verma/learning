package designPatterns.creational.abstractFactory.example_1;

public class UFOEnemyShip extends EnemyShip {
	
	private EnemyShipFactory shipFactory;
	
	public UFOEnemyShip(EnemyShipFactory shipFactory) {
		this.shipFactory = shipFactory;
	}
	
	@Override
	void makeShip() {
		System.out.println("Making Enemy Ship: " + getName());
		
		weapon = shipFactory.addESWeapon();
		engine = shipFactory.addESEngine();
	}

}
