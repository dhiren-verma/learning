package designPatterns.creational.singleton;

/**
 * Sixth Singleton Example:
 * 
 * Also known as Inner Static Helper Class Singleton.
 * 
 * Pros:	1. Lazy Initialized Singleton
 * 			2. The SingletonHelper(private inner static class) is not loaded
 * 			when the OuterClass is loaded. Its only loaded into memory when
 * 			getInstance() method is called
 * 
 * Cons:	1. If Module is publicly accessible, then Reflection can
 * 			be used	to Destroy the Design Pattern.
 * 			2. Its vulnerable to Cloning if the Superclass of this Class or
 * 			this Class itself is implementing Cloneable Interface.
 * 			3. Its also vulnerable to Serialization & De-serialization.
 * 
 * Use Case:Can be used generally and also in case of a Multi-Threaded
 * 			Environment Singleton requirement. Most widely used
 * 
 * @author Dhirendra Verma
 * 
 */
public class BillPughSingleton {
	
	private BillPughSingleton() {}
	
	private static class SingletonHelper {
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}
	
	public static BillPughSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
}