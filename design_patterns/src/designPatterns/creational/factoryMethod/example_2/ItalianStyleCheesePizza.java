package designPatterns.creational.factoryMethod.example_2;

/**
 * Represents Concrete Product:
 * 
 * @author Dhirendra Verma
 */
public class ItalianStyleCheesePizza extends Pizza {
	
	@Override
	public void prepare() {
		setCrustType("Thin Crust");
		getToppings().add("Cheese");
		getToppings().add("Cheese");
		System.out.println("Preparing Italian Style Cheese Pizza...");
	}
	
	@Override
	public void bake() {
		System.out.println("Baking Italian Style Cheese Pizza...");
	}
	
	@Override
	public void cut() {
		System.out.println("Cutting Italian Style Cheese Pizza...");
	}
	
	@Override
	public void box() {
		System.out.println("Boxing Italian Style Cheese Pizza...");
	}
	
}
