package learning.java8;

public class InterfaceDefaultAndStaticMethodsPOC {

	/**
	 * Before Java 8, Interfaces could only have pure abstract methods, but
	 * with Java 8, Default Methods & Static Methods were introduced for Interfaces
	 * 
	 * 
	 * What I believe led to this up[date was that Java Language was progressing
	 * towards some remarkable breakthroughs, which might have made code written
	 * on Older Java Version compliance level to no longer work.   
	 * Also it would have led to complete redesign of the API or Framework whose
	 * Interfaces just wanted to add some more functionality, as it would have
	 * broken all implementing Concrete Classes to also provide the functionality
	 * for all of the added new Methods,
	 * hence the default methods, which make the mandatory burden of providing
	 * functionality for a method defined in Interface as Optional.    
	 *  
	 */
	interface Java8Interface {
		
		//This static method is only available through & inside the Interface.
		//Also it can't be overridden by an implementing class. 
		static String getFeatureJavaVersion() {
			return "introduced in Java-8";
		}
		
		//Declared using the new 'default' keyword. Accessible via instance of
		//an Implementing Class and can be overridden
		default String justDefaultMethod() {
			return  ("Default Method from Interface\n"+getFeatureJavaVersion());
		}
		
		void displayInformation();
		
	}
	
	class Java8InterfaceImpl implements Java8Interface {
		
		@Override
		public void displayInformation() {
			System.out.println(justDefaultMethod());
		}
		
		public void someOtherMethod() {
			System.out.println(justDefaultMethod());
		}
		
	}
	
	public static void main (String[] args) {
		InterfaceDefaultAndStaticMethodsPOC enclosingObject =
				new InterfaceDefaultAndStaticMethodsPOC();
		
		Java8Interface obj = enclosingObject.new Java8InterfaceImpl();
		
		//Can directly call a Default Method from instance of Implementing Class:
		System.out.println(obj.justDefaultMethod());
		
		//Can call a pure Virtual Method from Interface which is implemented in Implementing Class,  
		//which calls the Default Method:
		obj.displayInformation();
		
		//Can call a new Method from Implementing Class,
		//which in turn calls the default method from Interface:
		if (obj instanceof Java8InterfaceImpl) {
			Java8InterfaceImpl implObj = (Java8InterfaceImpl) obj;
			
			implObj.someOtherMethod();
		}
	}
	
}
