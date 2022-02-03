package learning.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsPOC {
	
	/**
	 * Collectors is a final class that extends Object class. It provides reduction
	 * operations, such as accumulating elements into collections, summarizing
	 * elements according to various criteria, etc.
	 * 
	 * All the Methods inside Collectors class are static.
	 * 
	 */
	class Product {
		final int id;
		final String name;
		final float price;
		
		public Product(int id, String name, float price) {
			this.id = id;
			this.name = name;
			this.price = price;
		}
		
		public int getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public float getPrice() {
			return price;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Objects.hash(id);
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Product other = (Product) obj;
			
			return id == other.id;
		}
		
	}
	
	public static void main(String[] args) {
		CollectorsPOC obj = new CollectorsPOC();
		List<Product> products = new ArrayList<>();
		
		products.add(obj.new Product(1, "HP Laptop", 45000.0f));
		products.add(obj.new Product(2, "Dell", 45000.0f));
		products.add(obj.new Product(3, "Lenovo", 50000.0f));
		products.add(obj.new Product(4, "Asus", 53000.0f));
		products.add(obj.new Product(5, "Apple", 70000.0f));
		
		//Collecting Data as List:
		List<Float> productPrices = products.stream().map(Product::getPrice).collect(Collectors.toList());
		
		System.out.println("Product Price List is: " + productPrices);
		
		//Collecting Data as Set:
		Set<Float> uniqueProdcutPrices = products.stream().map(Product::getPrice).collect(Collectors.toSet());
		
		System.out.println("Unique Product Prices are: " + uniqueProdcutPrices);
		
		//Using Summing Function:
		Double allItemCombinedPrice = products.stream().collect(Collectors.summingDouble(Product::getPrice));
		
		System.out.println("All Items combined Price is: "+allItemCombinedPrice);
		
		//Using Averaging Function:
		Double averageProductPrice = products.stream().collect(Collectors.averagingDouble(Product::getPrice));
		
		System.out.println("Average Price of Items is: "+averageProductPrice);
		
		//Counting no of elements:
		long productCount = products.stream().count();
		
		System.out.println("No of Products are: "+productCount);
		
		System.out.println(products.stream().collect(Collectors.summarizingDouble(Product::getPrice)).getMin());		
		
		//Applying as transformation after collecting using collectingAndThen:
		List<Product> unmodifiableProducts = (List<Product>) products.stream().collect(Collectors.
					collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		
	}

}
