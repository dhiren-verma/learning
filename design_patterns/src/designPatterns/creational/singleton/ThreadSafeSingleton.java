package designPatterns.creational.singleton;

/**
 * Fourht Singleton Example:
 * Pros:	Creates instance when the request comes for the first time.
 * 			Also as the Method itself is synchronized therefore its considered
 * 			to be Multi-Treading Safe.
 * 
 * Cons:	1. It reduces the performance because of the cost associated with
 * 			Synchronized method, as everytime we request for its Instance,
 * 			whereas all we wanted to do was to prevent multiple Instances of
 * 			Singleton to be initialized in case of Multi-Threaded Environment.
 * 			2. Also if Module is publicly accessible, then Reflection can
 * 			be used	to Destroy the Design Pattern.
 * 			3. Its vulnerable to Cloning if the Superclass of this Class or
 * 			this Class itself is implementing Cloneable Interface.
 * 			4. Its also vulnerable to Serialization & De-serialization.
 * 
 * Note:	Prior to Java5, Java memory model had a lot of issues & this
 * 			approach could still fail in certain scenarios where too many
 * 			threads try to get the Instance of the Singleton Class simultaneously. 
 * 
 * Use Case:Use only in case this will be used in a Multi-Threaded
 * 			Environment only, but still not recommended
 * 
 * @author Dhirendra Verma
 *
 */
public class ThreadSafeSingleton {
	
	private static volatile ThreadSafeSingleton instance = null;
	
	private ThreadSafeSingleton() {}
	
	public static synchronized ThreadSafeSingleton getInstance() {
		if (instance == null)
			instance = new ThreadSafeSingleton();
		
		return instance;
	} 
	
}