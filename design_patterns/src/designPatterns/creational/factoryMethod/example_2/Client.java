package designPatterns.creational.factoryMethod.example_2;

public class Client {

	public static void main(String[] args) {
		PizzaStore pizzaStore = new NYPizzaStore();
		
		Pizza pizza = pizzaStore.orderPizza("Cheese");
	}

}
