package designPatterns.creational.singleton;

/**
 * Third Singleton Example:
 * Pros:	Creates instance when the request comes for the first time.
 * 
 * Cons:	1. Singleton Pattern falls apart in case of Multi-Threaded
 * 			Environment, if multiple threads simultaneously try get
 * 			a Singleton Instance initially, then they may get different
 * 			instances of Singleton Class.
 * 			2. Also if Module is publicly accessible, then Reflection can
 * 			be used	to Destroy the Design Pattern.
 * 			4. Its vulnerable to Cloning if the Superclass of this Class or
 * 			this Class itself is implementing Cloneable Interface.
 * 			5. Its also vulnerable to Serialization & De-serialization.
 * 
 * Use Case:Use only in case this will be used in a Single Threaded
 * 			Environment only.
 * 
 * @author Dhirendra Verma
 * 
 */
public class LazyInitializedSingleton {
	
	public static LazyInitializedSingleton instance = null;
	
	private LazyInitializedSingleton() {}
	
	public static LazyInitializedSingleton getInstance() {
		if (instance == null)
			instance = new LazyInitializedSingleton();
		
		return instance;
		
	}
	
}