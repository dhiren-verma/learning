package learning.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsRunner {

	public static void main(String[] args) {
		//This List will only hold String elements:
		MyCustomList<String> myList = new MyCustomList<>();
		
		myList.addElement("Hello 1");
		myList.addElement("Hello 2");
		
		System.out.println("List of String has elements:\n" + myList);
		
		String value = myList.get(1);
		System.out.println("String value extracted from myList is: " + value);
		
		
		//This List will only hold Integer elements:
		MyCustomList<Integer> mySecondList = new MyCustomList<>();
		
		mySecondList.addElement(12);
		mySecondList.addElement(19);
		
		System.out.println("List of Integer has elements:\n" + mySecondList);
		
		Integer number = mySecondList.get(0);
		System.out.println("Integer value extracted from mySecondList is: " + number);
		
		
		//This List will only hold Number & its Subclass elements & nothing else is allowed:
		//As Long is a subclass of Number, hence of MyCustomNumberList of Long is allowed:
		MyCustomNumberList<Long> numberList = new MyCustomNumberList<>();
		
		numberList.addElement(101l);
		numberList.addElement(219l);
		
		System.out.println("List of Number & Subtypes has elements:\n" + numberList);
		
		Number firstElement = numberList.get(0);
		Long secondElement = numberList.get(1);
		System.out.println("First Number of type Number is: " + firstElement +
				"\nSecond Number of type Long is: "+secondElement);
		
		//This will not be allowed as Character is not a Number subclass:
//		MyCustomNumberList<Character> doubleNumberList = new MyCustomNumberList<>();
		
		
		//Lets call Generic Methods:
		String cyz = revertValue(new String("abc"));
		Integer num = revertValue(Integer.valueOf(5));
		System.out.println("String value is: " + cyz);
		System.out.println("Number value is:" + num);
		
		
		//Parameter Type restricted Generic Method example:
		ArrayList<Integer> numbers = new ArrayList<>();
		
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		
		duplicateElements(numbers);
		
		System.out.println("Duplicated Number List is: " + numbers);
		
		
		List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3));
		List<Double> doubleList = new ArrayList<>(Arrays.asList(1.1, 2.1, 3.1));
		List<Long> longList = new ArrayList<>(Arrays.asList(1l, 2l, 5l)); 
		System.out.println("Sum of List of Integers is: " + sumOfNumberList(intList));
		System.out.println("Sum of List of Double is: " + sumOfNumberList(doubleList));
		System.out.println("Sum of List of Long is: " + sumOfNumberList(longList));
		
		List<Number> emptyList = new ArrayList<>();
		
		addACoupleOfValues(emptyList);
		
		System.out.println("List of Numbers with some Entries added is:" + emptyList);
	}

	//Generic Arguments with Methods:
	static <X> X revertValue(X value) {
		return value;
	}

	//Generally in case of Generics with Methods(whose Class is not Type Secured using Generics)
	//its best to limit the Generic Parameter to certain types, like as mentioned below:
	//The benefit would be that all the methods available to List implementations will be
	//available in this Method:
	static <X extends List> void duplicateElements(X list) {
		list.addAll(list);
	}

	//Wildcards(symbols like '?') can also be used in case using Generics, but there is a restriction
	//as to where all they can be used:
	//1. We can't mention a Type for a Class using Wildcard.
	//2. Wildcards can only be used with Methods & their Local and Member Variables:
	//This below example is an Upper Bounded Wild Card:
	static double sumOfNumberList(List<? extends Number> numbers) {
		double sum = 0.0;
		
		for (Number number : numbers) {
			sum += number.doubleValue();
		}
		
		return sum;
	}

	//Lower Bounded Wild Card:
	static void addACoupleOfValues(List<? super Number> numbers) {
		numbers.add(1);
		numbers.add(1.0);
		numbers.add(1.0f);
		numbers.add(1l);
	}

}
