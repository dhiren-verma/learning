package designPatterns.creational.singleton;

/**
 * Second Singleton Example:
 * It is similar to Eager Initialization Singleton Implementation,
 * just that using a Static block provides the option for Exception
 * Handling, in case something goes wrong while Initializing the
 * Instance if this Class.
 * 
 * Pros:	Provides for Exception Handling, in case something happens
 * 			during Instantiation of this Class. Exception can either be handled
 * 			in the Static Block itself, or it may be thrown; but one cannot
 * 			throw a Checked/Compile Time Exception.
 * 
 * Cons:	1. The Instantiation itself happens as soon as this Class is loaded
 * 			hence leading to memory consumption at a time when it might not
 * 			be needed.
 * 			2. We cannot throw a Checked/Compile Time Exception here as there is
 * 			no means to handle it as its Eager Initialized in Static Block & even
 * 			if we throw	Unchecked/Runtime Exception then also there will be no
 * 			means to handle it. We can only Handle the Exception in the Static
 * 			Block itself.
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
public class StaticBlockSingleton {
	
	private static final StaticBlockSingleton instance;
	
	static {
		instance = new StaticBlockSingleton();
	}
	
	private StaticBlockSingleton() {}
	
	public static StaticBlockSingleton getInstance() {
		return instance;
	}
	
}