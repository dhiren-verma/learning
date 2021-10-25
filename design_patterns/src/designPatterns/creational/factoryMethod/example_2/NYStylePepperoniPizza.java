package designPatterns.creational.factoryMethod.example_2;

public class NYStylePepperoniPizza extends Pizza {
	
	@Override
	public void prepare() {
		setCrustType("Standard Crust");
		getToppings().add("Cheese");
		getToppings().add("Pepperoni");
		System.out.println("Preparing NY Style Pepperoni Pizza...");
	}
	
	@Override
	public void bake() {
		System.out.println("Baking NY Style Pepperoni Pizza...");
	}
	
	@Override
	public void cut() {
		System.out.println("Cutting NY Style Pepperoni Pizza...");
	}
	
	@Override
	public void box() {
		System.out.println("Boxing NY Style Pepperoni Pizza...");
	}
	
}