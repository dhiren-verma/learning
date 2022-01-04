package designPatterns.creational.factoryMethod.example_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents Product/Abstract Product:
 * 
 * @author Dhirendra Verma
 */
public abstract class Pizza {
	
	private String crustType;
	private List<String> toppings;
	
	public Pizza() {
		toppings = new ArrayList<>();
	}
	
	public abstract void prepare();
	public abstract void bake();
	public abstract void cut();
	public abstract void box();
	
	public String getCrustType() {
		return crustType;
	}
	
	public void setCrustType(String crustType) {
		this.crustType = crustType;
	}
	
	public List<String> getToppings() {
		return toppings;
	}
	
}