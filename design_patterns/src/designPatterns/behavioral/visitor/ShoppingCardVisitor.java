package designPatterns.behavioral.visitor;

/**
 * Visitor Pattern is used when we have to perform an Operation on a group of Similar Objects.
 * With the help of Visitor Pattern we can move the Operation Logic from these Similar Objects
 * to another Class.
 * 
 * In our example, Item implementations represent similar Objects/Elements
 * 
 * 
 * First benefit of this pattern is that if the logic of operation changes, then we need to make
 * change only in the Visitor implementation rather than doing it in all the Item implementation
 * classes.
 * Second benefit is that adding a new item to the system is easy, it will require change only in
 * Visitor interface and implementation and existing Item implementation classes will not be
 * affected.
 * 
 * First drawback of visitor pattern is that we should know the return type of visit() methods at
 * the time of designing otherwise we will have to change the interface and all of its implementations.
 * Another drawback is that if there are too many implementations of visitor interface, it makes
 * it hard to extend by the Implementation Classes.
 * 
 * This example is a little bit simple to show the pattern applicability.
 * 
 * Image we have to add the freight to the price calculation. Freight price will vary according to
 * the region. These rules should not be calculated inside the Item implementation classes as they
 * don’t care about freight costs.
 * 
 * One possible solution would be the creation of multiple concrete visitors, one for each region.
 * These visitors will hold the responsibility to calculate the freight costs and return the total
 * price. For Example:
 *
 * public class SouthRegionVisitor implements ShoppingCartVisitor {
 * 		
 * 		public int visit (Book book) {
 * 			int freightCost = calculateFreightForSouthRegion(book.getWeight());
 * 			return book.price + freightCost;
 * 		}
 * 		
 * }
 * 
 * public class NorthRegionVisitor implements ShoppingCartVisitor {
 * 		
 * 		public int visit (Book book) {
 * 			int freightCost = calculateFreightForSouthRegion(book.getWeight());
 * 			return book.price + freightCost;
 * 		}
 * 		
 * }
 * 
 * // and so on
 * 
 * @author Dhirendra
 */
public interface ShoppingCardVisitor {
	
	public int visit(Book book);
	public int visit(Fruit fruit);
	
}