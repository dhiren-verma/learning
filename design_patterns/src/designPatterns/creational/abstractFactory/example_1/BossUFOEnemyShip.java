package designPatterns.creational.abstractFactory.example_1;

public class BossUFOEnemyShip extends EnemyShip {

	private EnemyShipFactory shipFactory;
	
	public BossUFOEnemyShip(EnemyShipFactory shipFactory) {
		this.shipFactory = shipFactory;
	}
	
	
	
	@Override
	void makeShip() {
		System.out.println("Making Enemy Ship: " + getName());
		
		weapon = shipFactory.addESWeapon();
		engine = shipFactory.addESEngine();
	}

}
