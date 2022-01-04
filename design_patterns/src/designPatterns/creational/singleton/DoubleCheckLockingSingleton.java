package designPatterns.creational.singleton;
/**
 * Fifth Singleton Example:
 * 
 * Pros:	Lazy Initialized Singleton and Synchronized Block is used inside
 * 			if condition with an additional check to ensure that only one
 * 			instance of Singleton Class is created.
 * 
 * Cons:	1. Very minute Synchronization Performance issue due to one time
 * 			Synchronization
 * 			2. Also if Module is publicly accessible, then Reflection can
 * 			be used	to Destroy the Design Pattern.
 * 			3. Its vulnerable to Cloning if the Superclass of this Class or
 * 			this Class itself is implementing Cloneable Interface.
 * 			4. Its also vulnerable to Serialization & De-serialization.
 * 
 * Note:	Prior to Java5, Java memory model had a lot of issues & this
 * 			approach could still fail in certain scenarios where too many
 * 			threads try to get the Instance of the Singleton Class simultaneously.
 * 			Post Java5, either using 'volatile' keyword or making 'instance' an
 * 			Immutable Object will make sure that this Approach works in case of
 * 			Multi-Threaded environment. 
 * 
 * Use Case:Can be used generally and also in case of a Multi-Threaded
 * 			Environment Singleton requirement
 * 
 * @author Dhirendra Verma
 * 
 */
public class DoubleCheckLockingSingleton {
	
	private static volatile DoubleCheckLockingSingleton instance = null;
	
	private DoubleCheckLockingSingleton() {}
	
	public static DoubleCheckLockingSingleton getInstance() {
		if (instance == null) {
			synchronized(DoubleCheckLockingSingleton.class) {
				if (instance == null)
					instance = new DoubleCheckLockingSingleton();
				
			}
		}
		
		return instance;
	}
	
}