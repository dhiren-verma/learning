package designPatterns.creational.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestSingletonDesignPattern {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
	IllegalArgumentException, InvocationTargetException, FileNotFoundException, IOException,
	ClassNotFoundException {
		//Lets check EagerInitializedSingleton: 
		EagerInitializedSingleton eagerInstance = EagerInitializedSingleton.getInstance();
		EagerInitializedSingleton secondEagerInstance = EagerInitializedSingleton.getInstance();
		
		checkSingleton(eagerInstance, secondEagerInstance, "EagerInitializedSingleton");
		
		EagerInitializedSingleton reflectionEagerInstance = null;
		Constructor[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
		
		for (Constructor constructor : constructors) {
			constructor.setAccessible(true);
			reflectionEagerInstance = (EagerInitializedSingleton) constructor.newInstance();
			break;
		}
		
		checkSingletonIntegrity(eagerInstance, reflectionEagerInstance, "EagerInitializedSingleton");
		
		
		
		//Lets check StaticBlockSingleton:
		StaticBlockSingleton staticBlockInstance = StaticBlockSingleton.getInstance();
		StaticBlockSingleton secondStaticBlockInstance = StaticBlockSingleton.getInstance();
		
		checkSingleton(staticBlockInstance, secondStaticBlockInstance, "StaticBlockSingleton");
		
		StaticBlockSingleton reflectionStaticBlockInstance = null;
		constructors = StaticBlockSingleton.class.getDeclaredConstructors();
		
		for (Constructor constructor : constructors) {
			constructor.setAccessible(true);
			reflectionStaticBlockInstance = (StaticBlockSingleton) constructor.newInstance();
			break;
		}
		
		checkSingletonIntegrity(staticBlockInstance, reflectionStaticBlockInstance, "StaticBlockSingleton");
		
		
		
		//Lets check LazyInitializedSingleton:
		LazyInitializedSingleton lazyInstance = LazyInitializedSingleton.getInstance();
		LazyInitializedSingleton secondLazyInstance = LazyInitializedSingleton.getInstance();
		
		checkSingleton(lazyInstance, secondLazyInstance, "LazyInitializedSingleton");
		
		LazyInitializedSingleton reflectionLazyInstance = null;
		constructors = LazyInitializedSingleton.class.getDeclaredConstructors();
		
		for (Constructor constructor : constructors) {
			constructor.setAccessible(true);
			reflectionLazyInstance = (LazyInitializedSingleton) constructor.newInstance();
			break;
		}
		
		checkSingletonIntegrity(lazyInstance, reflectionLazyInstance, "LazyInitializedSingleton");
		
		
		
		//Lets check ThreadSafeSingleton:
		ThreadSafeSingleton threadSafeInstance = ThreadSafeSingleton.getInstance();
		ThreadSafeSingleton secondThreadSafeInstance = ThreadSafeSingleton.getInstance();
		
		checkSingleton(threadSafeInstance, secondThreadSafeInstance, "ThreadSafeSingleton");
		
		ThreadSafeSingleton reflectionThreadSafeInstance = null;
		constructors = ThreadSafeSingleton.class.getDeclaredConstructors();
		
		for (Constructor constructor : constructors) {
			constructor.setAccessible(true);
			reflectionThreadSafeInstance = (ThreadSafeSingleton) constructor.newInstance();
			break;
		}
		
		checkSingletonIntegrity(threadSafeInstance, reflectionThreadSafeInstance, "ThreadSafeSingleton");
		
		
		
		//Lets check DoubleCheckLockingSingleton:
		DoubleCheckLockingSingleton doubleCheckLockInstance = DoubleCheckLockingSingleton.getInstance();
		DoubleCheckLockingSingleton secondDoubleCheckLockInstance = DoubleCheckLockingSingleton.getInstance();

		checkSingleton(doubleCheckLockInstance, secondDoubleCheckLockInstance, "DoubleCheckLockingSingleton");
		
		DoubleCheckLockingSingleton reflectionDoubleCheckLockInstance = null;
		constructors = DoubleCheckLockingSingleton.class.getDeclaredConstructors();
		
		for (Constructor constructor : constructors) {
			constructor.setAccessible(true);
			reflectionDoubleCheckLockInstance = (DoubleCheckLockingSingleton) constructor.newInstance();
			break;
		}
		
		checkSingletonIntegrity(doubleCheckLockInstance, reflectionDoubleCheckLockInstance, "DoubleCheckLockingSingleton");
		
		
		
		//Lets check BillPughSingleton:
		BillPughSingleton billPughInstance = BillPughSingleton.getInstance();
		BillPughSingleton secondBillPughInstance = BillPughSingleton.getInstance();
		
		checkSingleton(billPughInstance, secondBillPughInstance, "BillPughSingleton");
		
		BillPughSingleton reflectionBillPughInstance = null;
		constructors = BillPughSingleton.class.getDeclaredConstructors();
		
		for (Constructor constructor : constructors) {
			constructor.setAccessible(true);
			reflectionBillPughInstance = (BillPughSingleton) constructor.newInstance();
			break;
		}
		
		checkSingletonIntegrity(billPughInstance, reflectionBillPughInstance, "BillPughSingleton");
		
		//These all can also be broken using Cloning or using Serialization & De-serialization,
		//if any if their Superclass that they inherit from or they themselves implement Cloneable
		//or Serializable Interface:
		
		//How to safeguard from Reflection:
		//1. Run your application using a SecurityManager & a sufficiently restrictive Security Policy.
		//2. In the Constructor check if its being accessed using some other Class, if so throw an Exception.
		
		//How to safeguard from Cloning & Serialization & De-serialization:
		//1. To prevent against Cloning just Override the clone() method & throw a
		//	 CloneNotSupportedException.
		//2. To prevent against Serialization & De-serialization, override the readResolve() method
		//	 & in that method just call the Factory Method that returns the Singleton Instance.
		PerfectSingleton perfectInstance = PerfectSingleton.getInstance();
		PerfectSingleton secondPerfectInstance = PerfectSingleton.getInstance();
		
		checkSingleton(perfectInstance, secondPerfectInstance, "PerfectSingleton");
		
		PerfectSingleton reflectionInstance = null;
		constructors = PerfectSingleton.class.getDeclaredConstructors();
		
		try {
			for (Constructor constructor : constructors) {
				constructor.setAccessible(true);
				reflectionInstance = (PerfectSingleton) constructor.newInstance();
				break;
			}
			
			checkSingletonIntegrity(perfectInstance, reflectionInstance, "PerfectSingleton");
		} catch (Exception ex) {
			System.out.println("Perfect Singleton couldn't be broken using Reflection");
		}
		
		try {
			reflectionInstance = perfectInstance.clone();
		} catch (Exception ex) {
			System.out.println("Perfect Singleton couldn't be broken using Cloning");
		}
		
		String fileName = "serializedSingleton.ser";
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream(fileName));
		out.writeObject(perfectInstance);
		out.close();
		
		ObjectInput in = new ObjectInputStream(new FileInputStream(fileName));
		PerfectSingleton deserializedInstance = (PerfectSingleton) in.readObject();
		in.close();
		
		checkSerializedSingletonIntegrity(perfectInstance, deserializedInstance);
	}
	
	private static void checkSingleton(Object firstInstance, Object secondInstance,
			String singletonStrategy) {
		if (firstInstance == secondInstance)
			System.out.println("Singleton Pattern using " + singletonStrategy + "\n" +
					"First Instance Hashcode: " + firstInstance.hashCode() + "\n" +
					"Second Instance Hascode: " + secondInstance.hashCode() +
					"\n\n");
		else
			System.out.println(singletonStrategy + " could create a Singleton\n" +
					"First Instance Hashcode: " + firstInstance.hashCode() + "\n" +
					"Second Instance Hascode: " + secondInstance.hashCode() +
					"\n\n");
	}
	
	private static void checkSingletonIntegrity(Object defaultInstance,
			Object reflectionInstance, String singletonStrategy) {
		if (defaultInstance == reflectionInstance)
			System.out.println("Reflection couldn't break " + singletonStrategy + "\n" +
					"SingletonInstance Hashcode: " + defaultInstance.hashCode() + "\n" +
					"Reflection SingletonInstance Hascode: " + reflectionInstance.hashCode() +
					"\n");
		else
			System.out.println(singletonStrategy + " has been broken by Reflection\n" +
					"SingletonInstance Hashcode: " + defaultInstance.hashCode() + "\n" +
					"Reflection SingletonInstance Hascode: " + reflectionInstance.hashCode() +
					"\n");
	}

	private static void checkSerializedSingletonIntegrity(Object defaultInstance,
			Object reflectionInstance) {
		if (defaultInstance == reflectionInstance)
			System.out.println("Serialization & Deserialization couldn't break Singleton" + "\n" +
					"SingletonInstance Hashcode: " + defaultInstance.hashCode() + "\n" +
					"Reflection SingletonInstance Hascode: " + reflectionInstance.hashCode() +
					"\n\n");
		else
			System.out.println("Singleton has been broken by Serialization & Deserialization\n" +
					"SingletonInstance Hashcode: " + defaultInstance.hashCode() + "\n" +
					"Reflection SingletonInstance Hascode: " + reflectionInstance.hashCode() +
					"\n\n");
	}
	
	
	
}