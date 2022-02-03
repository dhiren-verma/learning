package learning.java8;

public class StreamAndStreamFilterPOC {
	
	/**
	 * Java provides a new additional package in Java 8 called java.util.stream.
	 * This package consists of classes, interfaces and enum to allow
	 * functional-style operations on the elements.
	 * 
	 * Stream provides following features:
	 * 1. Stream does not store elements. It simply conveys elements from a
	 * 	  source such as a data structure, an array, or an I/O channel,
	 * 	  through a pipeline of computational operations.
	 * 2. Stream is functional in nature. Operations performed on a stream
	 * 	  does not modify it's source. For example, filtering a Stream
	 * 	  obtained from a collection produces a new Stream without the
	 * 	  filtered elements, rather than removing elements from the source
	 * 	  collection.
	 * 3. Stream is lazy and evaluates code only when required.
	 * 4. The elements of a stream are only visited once during the life of
	 * 	  a stream. Like an Iterator, a new stream must be generated to
	 * 	  revisit the same elements of the source.
	 * 
	 * Java stream provides a method filter() to filter stream elements on the
	 * basis of given predicate. This method takes predicate as an argument and
	 * returns a stream of consisting of resulted elements.
	 */
}
