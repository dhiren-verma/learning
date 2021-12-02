package designPatterns.creational.abstractFactory.example_1;

//Strategy Design Pattern is being used here, as we can vary ESWeapon
//Implementations dynamically
public class ESUFOWeapon implements ESWeapon {
	
	@Override
	public String getDamage() {
		return "20";
	}
	
}