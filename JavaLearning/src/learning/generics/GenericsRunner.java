package learning.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

public class GenericsRunner {
	
	//Generic Arguments with Methods:
	static <X> X doubleValue(X value) {
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
	
	
	public static void main(String[] args) {
		MyCustomList<String> myList = new MyCustomList<>();
		
		myList.addElement("Hello 1");
		myList.addElement("Hello 2");
		
		String value = myList.get(1);
		
		
		System.out.println(myList);
		
		MyCustomList<Integer> mySecondList = new MyCustomList<>();
		
		mySecondList.addElement(12);
		mySecondList.addElement(19);
		
		Integer number = mySecondList.get(0);
		
		System.out.println(mySecondList);
		
		//For this List we can't use any other Reference other than Number or its Subclasses: 
		MyCustomNumberList<Long> numberList = new MyCustomNumberList<>();
		
		
		//Lets call Generic Methods:
		String cyz = doubleValue(new String());
		Integer num = doubleValue(Integer.valueOf(5));
		
		ArrayList<Integer> numbers = new ArrayList<>();
		
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		
		duplicateElements(numbers);
		
		System.out.println(numbers);
		
		List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3));
		List<Double> doubleList = new ArrayList<>(Arrays.asList(1.1, 2.1, 3.1));
		List<Long> longList = new ArrayList<>(Arrays.asList(1l, 2l, 5l)); 
		System.out.println(sumOfNumberList(intList));
		System.out.println(sumOfNumberList(doubleList));
		System.out.println(sumOfNumberList(longList));
		
		List<Number> emptyList = new ArrayList<>();
		
		addACoupleOfValues(emptyList);
		
		System.out.println(emptyList);
	}

}
