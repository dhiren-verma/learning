package designPatterns.creational.factoryMethod.example_2;

public class NYPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String type) {
		Pizza pizza = null;
		
		if (type.equalsIgnoreCase("pepperoni"))
			pizza = new NYStylePepperoniPizza();
		else if (type.equalsIgnoreCase("cheese"))
			pizza = new NYStyleCheesePizza();
		
		return pizza;
	}
	
}