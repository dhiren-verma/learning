package learning.java8;

interface Calculator {
	
	public void add(int num1, int num2);
	
}

class Calc {
	
	public static void addSomething(int value1, int value2) {
		System.out.println("Addition of "+value1+" and "+value2+" is: "+(value1+value2));
	}
	
	public void letsAdd(int val1, int val2) {
		System.out.println("Sum of "+val1+" and "+val2+" is: "+(val1+val2));
	}
	
}

interface Messenger {
	Message getMessage(String msg);
}

class Message {
	
	Message(String msg) {
		System.out.println("Message is: "+msg);
	}
	
}


//Check MethodReferencePOC, thats a full covering example:
public class LambdaExpressions {

	public static void main(String[] args) {
		//1. Reference to a static method:
		Calculator cRef = Calc::addSomething;
		cRef.add(100, 19);
		
		//2. Reference to an instance method of a Particular Object:
		Calc newCalc = new Calc();
		Calculator cRef1 = newCalc::letsAdd;
		cRef1.add(12, 34);
		
		//3. Reference to an instance method of an Arbitrary Object of a Particular Type:
		
		
		//4. Reference to a Constructor:
		Messenger mRef = Message::new;
		mRef.getMessage("Hello!");
		 
	}

}
