package designPatterns.creational.abstractFactory.example_1;

public abstract class EnemyShip {
	
	private String name;
	ESWeapon weapon;
	ESEngine engine;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	abstract void makeShip();
	
	public void followHeroShip() {
		System.out.println(getName() + " is following the Hero at " + engine.getSpeed());
	}
	
	public void displayEnemyShip() {
		System.out.println(getName() + " is on the Horizon");
	}
	
	public void attackHeroShip() {
		System.out.println(getName() + "attacks Hero Ship and does " + weapon.getDamage() + " Damage");
	}

	@Override
	public String toString() {
		String infoOnShip = "The name: " + getName() + " has a Top Speed of: " + engine.getSpeed() +
				" and does "+weapon.getDamage() + " when attacking";
		return infoOnShip;
	}
	
}
