package designPatterns.creational.singleton;

import java.io.Serializable;

/**
 * This is an Example of a Perfect Singleton, which can protect itself against
 * Reflection, Cloning & Serialization & De-serialization.   
 * Although its over-engineered for the same sake, but in Real World scenarios,
 * Singleton will be at risk from Reflection only, Unless the Singleton Class
 * or its SuperClass hierarchy implements Cloneable or Serializable Interface(s).  
 * 
 * @author Dhirendra Verma
 * 
 */
public class PerfectSingleton implements Cloneable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 581008718146915632L;
	
	private PerfectSingleton() {
		checkPermission();
	};
	
	private void checkPermission() {
		StackTraceElement[] stackTrace = new Exception().getStackTrace();
		
		if (stackTrace.length > 4 &&
				(stackTrace[4].getClassName().equals("java.lang.reflect.Constructor")))
			throw new RuntimeException("This Constructor can't be accessed by any other class other than 'PerfectSinglton'");
		
	}
	
	private static class SingletonHelper {
		private static final PerfectSingleton INSTANCE = new PerfectSingleton();
	}
	
	public static PerfectSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	@Override
	protected PerfectSingleton clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("PerfectSinglton can't be Cloned");
	}
	
	protected Object readResolve() {
		return SingletonHelper.INSTANCE;
	}
	
}