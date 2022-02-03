package learning.java8;

import java.util.ArrayList;
import java.util.List;

public class ForEachPOC {
	
	
	/**
	 * Java-8 introduced new forEach() to iterate over Elements in a Collection.
	 * This new method is defined in Iterable and Stream Interface.
	 * Inside Iterable Interface, new forEach() is defined as a Default Method
	 * Method signature is:
	 * 		void forEach(Consumer<? extends T> action)
	 * 
	 * It takes a FunctionalInterface as Parameter, which makes it a candidate
	 * for using Lambda Expression.
	 * 
	 * The behavior of forEach() Method id non-deterministic. For parallel stream
	 * pipelines, this operation doesn't guarantee to respect the encounter order
	 * of the stream, as doing so would sacrifice the benefit of parallelism.
	 * For any given element the action may be performed at whatever time and in
	 * whatever thread the library chooses.
	 * If the action accesses shared state, it is responsible for providing the
	 * required synchronization.
	 * 
	 * 
	 * Along with forEach(), forEachOrdered() has also been introduced in Stream
	 * Method signature is:
	 * 		void forEachOrdered(Consumer<? extends T> action)
	 * 
	 * It also takes a Functional Interface as Parameter, which makes it a candidate
	 * for using Lambda Expression.
	 * It performs an action for each element of this Stream, in the encounter order
	 * of the Stream, if the Stream has a defined encounter order
	 * This operation processes the elements one at a time in encounter order if one
	 * exists. Performing the action for one element 'happens-before' performing the
	 * action for subsequent elements, but for any given element, the action may be
	 * performed in whatever thread the library chooses.
	 */
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		
		names.add("Mahesh");
		names.add("Sunita");
		names.add("Dhirendra");
		names.add("Karan");
		names.add("Shubhi");
		
		//Stream.forEach() with Lambda Expression: Parallel Execution
		names.stream().forEach(name -> System.out.println(name));
		
		System.out.println();
		
		//Stream.forEach() with Static Method Reference: Parallel Execution
		names.stream().forEach(System.out::println);
		
		System.out.println();
		
		//Stream.forEach() with Lambda Expression: Non-Parallel Execution
		names.stream().forEachOrdered(name -> System.out.println(name));
		
		System.out.println();
		
		//Stream.forEach() with Static Method Reference: Non-Parallel Execution
		names.stream().forEachOrdered(System.out::println);
		
		
	}
}
