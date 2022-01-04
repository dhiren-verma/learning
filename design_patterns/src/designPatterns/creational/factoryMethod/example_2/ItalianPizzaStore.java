package designPatterns.creational.factoryMethod.example_2;

/**
 * Represents Concrete Creator:
 * Covers Parameterized Factory Method
 * 
 * @author Dhirendra Verma
 */
public class ItalianPizzaStore extends PizzaStore {
	
	@Override
	protected Pizza createPizza(PizzaType type) {
		Pizza pizza = null;
		
		if (type==PizzaType.PEPPERONI)
			pizza = new ItalianStylePepperoniPizza();
		else if (type==PizzaType.CHEESE)
			pizza = new ItalianStyleCheesePizza();
		
		return pizza;
	}
	
}