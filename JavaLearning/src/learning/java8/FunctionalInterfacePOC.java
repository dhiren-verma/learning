package learning.java8;

public class FunctionalInterfacePOC {
	
	/**
	 * Functional Interface is one which only has 1 Virtual Method,
	 * though it might contain any No. of Default or Static Methods.
	 * 
	 * In Java-8 a Functional Interface can be represented using an
	 * expression.
	 */
	interface Calculator<T extends Object> {
		T add(T firstNum, T secondNum);
	}
	
	interface Transform<T extends Object> {
		String transform(T value);
	}
	
	public static void main(String[] args) {
		//Anonymous Class implementation for Interface before Java-8:
		Calculator<Integer> intCalc =  new Calculator<Integer>() {
			
			@Override
			public Integer add(Integer firstNum, Integer secondNum) {
				return firstNum+secondNum;
			}
			
		};
		
		System.out.println(intCalc.add(100, 200));
		
		//Functional Interface with Lambda in Java-8:
		//A Lambda expression can have '0' or any number of arguments:
		Calculator<Integer> java8IntCalc =
				(firstNum, secondNum)-> {return firstNum+secondNum;};
		
		//If its just a Single Line Method implementation then we can use following too:
		//No need to write return if there is only a Single Line of Code:
		Calculator<Integer> java8Calc =
						(firstNum, secondNum)-> (firstNum+secondNum);
		
		System.out.println(java8IntCalc.add(209, 101));
		System.out.println(java8Calc.add(159,  192));
		
		
		//Different ways in which Lambda Expression can be written:
		Transform<Integer> transform = (value) -> {return value.toString();};
		Transform<String> secondTransform = value -> {return value.toUpperCase();};
		Transform<String> thirdTransform = value -> (value.toUpperCase());
		Transform<String> fourthTransform = value -> value.toUpperCase();
		Transform<String> fifthTransform = (String value) -> value.toUpperCase();
		
	}
	
}
