package designPatterns.creational.factoryMethod.example_2;

public class NYStyleCheesePizza extends Pizza {
	
	@Override
	public void prepare() {
		setCrustType("Standard Crust");
		getToppings().add("Cheese");
		getToppings().add("Cheese");
		System.out.println("Preparing NY Style Cheese Pizza...");
	}
	
	@Override
	public void bake() {
		System.out.println("Baking NY Style Cheese Pizza...");
	}
	
	@Override
	public void cut() {
		System.out.println("Cutting NY Style Cheese Pizza...");
	}
	
	@Override
	public void box() {
		System.out.println("Boxing NY Style Cheese Pizza...");
	}
	
}