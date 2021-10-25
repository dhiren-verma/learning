package designPatterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartClient {
	
	public static void main(String[] args) {
		List<Item> shoppingCart = new ArrayList<>();
		
		shoppingCart.add(new Book(50, "DataStructures & Algorithms", "1121"));
		shoppingCart.add(new Fruit(100, 2, "Apple"));
		
		int totalNCartValue = calculateNorthernRegionPrice(shoppingCart);
		int totalSCartValue = calculateSouthernRegionPrice(shoppingCart);
		
		System.out.println("Cart has items: "+shoppingCart);
		System.out.println("Total Worth of Cart Items for Northern Region is: " +totalNCartValue);
		System.out.println("Total Worth of Cart Items for Southern Region is: " +totalSCartValue);
	}
	
	private static int calculateNorthernRegionPrice(List<Item> shoppingCart) {
		int totalValue = 0;
		
		ShoppingCardVisitor cartVisitor = new NorthernRegionShoppingCardVisitor();
			
		totalValue = shoppingCart.stream().mapToInt(item -> item.accept(cartVisitor)).sum();
		
		return totalValue;
	}

	private static int calculateSouthernRegionPrice(List<Item> shoppingCart) {
		int totalValue = 0;
		
		ShoppingCardVisitor cartVisitor = new SouthernRegionShoppingCardVisitor();
		
		totalValue = shoppingCart.stream().mapToInt(item -> item.accept(cartVisitor)).sum();
		
		return totalValue;
	}
	
}