package designPatterns.creational.factoryMethod.example_2;

/**
 * Represents Concrete Creator:
 * Covers Parameterized Factory Method
 * 
 * @author Dhirendra Verma
 */
public class NYPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(PizzaType type) {
		Pizza pizza = null;
		
		if (type==PizzaType.PEPPERONI)
			pizza = new NYStylePepperoniPizza();
		else if (type==PizzaType.CHEESE)
			pizza = new NYStyleCheesePizza();
		
		return pizza;
	}
	
}