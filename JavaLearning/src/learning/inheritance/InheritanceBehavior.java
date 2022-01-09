package learning.inheritance;

public class InheritanceBehavior {
	
	public static void main(String[] args) {
		//The generic behavior of all Constructors of Derived Class is
		//to call the Default Constructor of Base Class first of all,
		//then all other code written in that Derived Class is executed.
		//So in case we we want Parameterized Constructor of Base Class
		//to be called in place of Default Constructor of Base Class,
		//then  we have to call that Parameterized Constructor of Base Class
		//in the first line of Code that we write in out Derived Class Constructor,
		//which may be a Default Constructor or a Derived Constructor in itself,
		//using the keyword 'super()'.
		//If Single Integer Parameter Base Class Constructor is to be called,
		//then we can use super(int), like super(210); 
		Base obj1 = new Derived();
		
		nextLine();
		
		Base obj2 = new Derived(25);

		nextLine();
		
		Base obj3 = new Derived(13, 27);

		nextLine();
		
		Derived obj4 = new Derived();

		nextLine();
		
		obj1.printData();
		nextLine();
		
		//Overriding only works with Instance Methods,
		//But for Static Methods, it doesn't, as static methods are resolved in static binding
		//Also using inctanc4e variables to call static methods is a bad practice,
		//as static methods are not associated with Instances at all. 
		obj2.print();		//Incorrect although just used to present the above mentioned case
//		Base.print();		//Correct way
		nextLine();
		
		//Any method that is exclusive to Derived class can only be accessed if
		//the Type of Instance Variable holding the Derived Class is Derived Class itself:
		//Otherwise these exclusive methods can't be called while using an instance of Superclass.
		//Why because although in case of Dynamic Polymorphism, the actual method that is called is resolved at run time,
		//but at least the method must be visible to compiler to compile that piece of code in the first place.
		obj4.printDerivedData();
		nextLine();
		
		Derived.print();
		
	}
	
	private static void nextLine() {
		System.out.println();
	}
	
}
