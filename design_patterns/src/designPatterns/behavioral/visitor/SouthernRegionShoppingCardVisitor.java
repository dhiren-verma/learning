package designPatterns.behavioral.visitor;

/**
 * Freight is different for Northern Region Visitor hence influencing the Final Charges
 * Also Region specific Freight is of no concern to the Items in the cart, therefore
 * Final Price related Calculation that also includes freight must be handled outside
 * Item Implementations, hence requiring Different ShoppingCartVisitor Implementations:
 * 
 * @author Dhirendra
 */
public class SouthernRegionShoppingCardVisitor implements ShoppingCardVisitor {
	
	@Override
	public int visit(Book book) {
		System.out.println(book);
		return southernFreightBilling(book.getPrice());
	}
	
	@Override
	public int visit(Fruit fruit) {
		System.out.println(fruit);
		return southernFreightBilling(fruit.getPricePerKg()*fruit.getWeightInKg());
	}
	
	private int southernFreightBilling(int cartValue) {
		int southernRegionFreight = 30;
		int finalBillingAmt = cartValue+southernRegionFreight;
		
		return finalBillingAmt;
	}
	
}