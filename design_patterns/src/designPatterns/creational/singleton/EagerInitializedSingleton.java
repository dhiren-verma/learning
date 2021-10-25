package designPatterns.creational.singleton;

/**
 * First Singleton Example:
 * Singleton Instance is created at the time Class is loaded
 * 
 * Cons:	1. Unnecessary Memory Wastage, as its Instance is created as soon
 * 			as the Application is loaded, whereas this Resource might be used
 * 			at some later instance.
 * 			2. We cannot throw a Checked/Compile Time Exception here as there is
 * 			no means to handle it as its Eager Initialized & even if we throw
 * 			Unchecked/Runtime Exception then also there will be no means to handle
 * 			it. Although we can handle the Exception in the Constructor itself.
 * 			3. Also if Module is publicly accessible, then Reflection can be used
 * 			to Destroy the Design Pattern.
 * 			4. Its vulnerable to Cloning if the Superclass of this Class or
 * 			this Class itself is implementing Cloneable Interface.
 * 			5. Its also vulnerable to Serialization & De-serialization.
 * 
 * Use Case:Use only in case Singleton is not using lot of resources
 * 
 * @author Dhirendra Verma
 * 
 */
public class EagerInitializedSingleton {
	
	private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
	
	private EagerInitializedSingleton() {}
	
	public static EagerInitializedSingleton getInstance() {
		return instance;
	}
	
}