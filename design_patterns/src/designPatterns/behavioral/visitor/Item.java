package designPatterns.behavioral.visitor;

public interface Item {
	
	/**
	 * This Method takes visitor argument, which will take ion the responsibility of executing
	 * the Operation Logic outside Item Implementation Classes.
	 * 
	 * @param visitor
	 * @return
	 */
	
	public int accept(ShoppingCardVisitor visitor);
	
}
