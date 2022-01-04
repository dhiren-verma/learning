package designPatterns.creational.factoryMethod.example_2;

public class Client {

	public static void main(String[] args) {
//		PizzaStore pizzaStore = new NYPizzaStore();
		PizzaStore pizzaStore = new ItalianPizzaStore();
		
		Pizza pizza = pizzaStore.orderPizza(PizzaType.PEPPERONI);
		
		System.out.println("\n"+pizza.getClass().getSimpleName()+
				" has "+pizza.getCrustType()+" and Toppings are:");
		pizza.getToppings().stream().forEach(System.out::println);
	}

}
