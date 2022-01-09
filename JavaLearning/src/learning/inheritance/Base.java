package learning.inheritance;

public class Base {
	
	private int x;
	
	public Base() {
		System.out.println("Default Constructor of Base Class");
		this.x = 10;
	}
	
	public Base(int x) {
		System.out.println("Parameterized Constructor of Base Class");
		this.x = x;
	}
	
	public void printData() {
		System.out.println("printData instance method of Base Class");
		System.out.println("Value held is: "+x);
	}
	
	public static void print() {
		System.out.println("print static method of Base Class");
	}
	
}
