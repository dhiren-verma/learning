package designPatterns.creational.factoryMethod.example_1;

/**
 * Represents Product/Abstract Product:
 * 
 * @author Dhirendra Verma
 */
public abstract class EnemyShip {
	
	private String name;
	private double amtDamage;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getAmtDamage() {
		return amtDamage;
	}
	
	public void setAmtDamage(double amtDamage) {
		this.amtDamage = amtDamage;
	}
	
	public void followHeroShip() {
		System.out.println(getName()+ " is following Hero Ship");
	}
	
	public void displayEnemyShip() {
		System.out.println(getName() + " is on the Screen");
	}
	
	public void enemyShipShoots() {
		System.out.println(getName() + " shoots & does " + getAmtDamage() + " damage");
	} 
	
}
