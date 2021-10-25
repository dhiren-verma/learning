package designPatterns.creational.factoryMethod.example_2;

public class ItalianPizzaStore extends PizzaStore {
	
	@Override
	protected Pizza createPizza(String type) {
		Pizza pizza = null;
		
		if (type.equalsIgnoreCase("pepperoni"))
			pizza = new ItalianStylePepperoniPizza();
		else if (type.equalsIgnoreCase("cheese"))
			pizza = new ItalianStyleCheesePizza();
		
		return pizza;
	}
	
}