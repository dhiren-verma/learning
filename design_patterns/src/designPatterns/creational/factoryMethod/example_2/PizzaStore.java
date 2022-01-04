package designPatterns.creational.factoryMethod.example_2;

/**
 * Represents Creator/Abstract Creator:
 * Covers Parameterized Factory Method
 * 
 * @author Dhirendra Verma
 */
public abstract class PizzaStore {
	
	public Pizza orderPizza(PizzaType type) {
		Pizza pizza = createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}
	
	protected abstract Pizza createPizza(PizzaType type);
	
}