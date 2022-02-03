package learning.java8;

import java.util.StringJoiner;

public class StringJoinerPOC {
	
	/**
	 * java.util.StringJoiner:
	 * It has two Constructors, one only takes a Delimiter CharSequence,
	 * other takes a Delimiter CharSequence, a Prefix CharSequence & a
	 * Suffix CharSequence
	 */
	public static void main(String[] args) {
		StringJoiner newStrJoiner = new StringJoiner(",");
		
		newStrJoiner.add("Ashish");
		newStrJoiner.add("Abhishek");
		
		System.out.println(newStrJoiner);
		
		StringJoiner secondStrJoiner = new StringJoiner(",", "{", "}");	//Delimitter, Prefix, Suffix
		secondStrJoiner.add("Goverdhan");
		secondStrJoiner.add("Jeetu");
		
		System.out.println(secondStrJoiner);
		
		//Merging Two String Joiner:
		StringJoiner merged = newStrJoiner.merge(secondStrJoiner);
		merged.add(null);
		
		System.out.println(merged);
		
		System.out.println("Merged String Joiner Length is: "+merged.length());
		
		StringJoiner emptyJoiner = new StringJoiner(":");
		emptyJoiner.setEmptyValue("Nothing here");
		
		System.out.println(emptyJoiner);
	}
}
