package designPatterns.behavioral.visitor;

public class Fruit implements Item {
	
	private int pricePerKg;
	private int weightInKg;
	private String name;
	
	public Fruit(int pricePerKg, int weightInKg, String name) {
		this.pricePerKg = pricePerKg;
		this.weightInKg = weightInKg;
		this.name = name;
	}
	
	public int getPricePerKg() {
		return pricePerKg;
	}
	
	public void setPricePerKg(int pricePerKg) {
		this.pricePerKg = pricePerKg;
	}
	
	public int getWeightInKg() {
		return weightInKg;
	}
	
	public void setWeightInKg(int weightInKg) {
		this.weightInKg = weightInKg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int accept(ShoppingCardVisitor visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "Fruit [Name=" + name + ", Weight(Kg)=" + weightInKg + ", Price(/Kg)=" + pricePerKg + "]";
	}
	
}
