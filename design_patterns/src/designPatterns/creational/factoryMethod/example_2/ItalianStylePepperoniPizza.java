package designPatterns.creational.factoryMethod.example_2;

/**
 * Represents Concrete Product:
 * 
 * @author Dhirendra Verma
 */
public class ItalianStylePepperoniPizza extends Pizza {
	
	@Override
	public void prepare() {
		setCrustType("Thin Crust");
		getToppings().add("Cheese");
		getToppings().add("Pepperoni");
		System.out.println("Preparing Italian Style Pepperoni Pizza...");
	}
	
	@Override
	public void bake() {
		System.out.println("Baking Italian Style Pepperoni Pizza...");
	}
	
	@Override
	public void cut() {
		System.out.println("Cutting Italian Style Pepperoni Pizza...");
	}
	
	@Override
	public void box() {
		System.out.println("Boxing Italian Style Pepperoni Pizza...");
	}
	
}