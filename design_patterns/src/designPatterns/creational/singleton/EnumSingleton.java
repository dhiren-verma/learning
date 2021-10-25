package designPatterns.creational.singleton;

/**
 * Seventh Singleton Example:
 * 
 * Pros:	1. Keeps the Singleton Pattern intact even if we try to break
 * 			it with Reflection, as it doesn't have any Constructor(s) which
 * 			could be used to exploit it using Reflection.
 * 			As in case of Enums, Java itself ensures that an Enum is
 * 			instantiated only once in a Java Program.
 * 			2. It can't be broken using Cloning or Serialization.
 * Cons:	1. It somewhat inflexible, for eg: It cannot be Lazy Initialized.
 * 
 * @author Dhirendra Verma
 * 
 */
public enum EnumSingleton {
	INSTANCE;
	
	public void someMethod() {
		//Do any processing required
	}
	
}