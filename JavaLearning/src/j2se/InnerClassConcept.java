package j2se;

public class InnerClassConcept {
	
	int i;
	
	public class B {
		
		int j;
		
		public void methodOne() {
			//It gets access to 2 'this':
			//One is for the Inner Class itself:
			this.j = 10;
			
			//Second is for the Outer Class:
			InnerClassConcept.this.i = 20;
		}
		
	}
	
	public static class C {
		
		int k;
		
		public static void methodTwo() {
			//Doesn't get access to any of 'this'
		}
		
		public void methodThree() {
			//Gets access to 'this' of Inner Class itself:
			this.k = 30;
		}
		
	}
	
}
