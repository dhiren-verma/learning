package learning.inheritance;

public class Derived extends Base {
	
	private int y;
	
	public Derived() {
		System.out.println("Default Consrtructor of Derived Class");
		y = 20;
	}
	
	public Derived(int y) {
		System.out.println("Single Parameterized Constructor of Derived Class");
		this.y = y;
	}
	
	public  Derived(int x, int y) {
		super(x);
		System.out.println("Double Parameterized Constructor of Derived Class");
		this.y = y;
	}
	
	public void printDerivedData() {
		System.out.println("printDerivedData instance method of Derived Class");
		System.out.println("Value held is: "+y);
	}
	
	public void printData() {
		super.printData();
		System.out.println("printData instance method of Derived Class");
		System.out.println("Value held is: "+y);
		super.printData();
		
		//Can also call static method from Base class using super keyword, but it won't be right,
		//its better to call a static method in static manner only.
//		super.print();	-	Improper
//		Base.print();	-	Proper
	}
	
	public static void print() {
		//super or this is not available to static methods.
		Base.print();
		System.out.println("print static method of Derived Class");
		Base.print();
	}
	
}
