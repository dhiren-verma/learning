package learning.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalPOC {
	
	/**
	 * Before Java-8, Developers had to carefully validate values they referred to,
	 * because of possibility of throwing NullPointerException.
	 * All these checks demanded a pretty annoying error prone boilerplate code
	 * 
	 * Optional<T> can help to handle situations where there is a possibility of
	 * getting Null Pointer Exception. It works as a container for the Object of
	 * type T. It can return the value of this Object if the value is not null.
	 * When the value inside this Container is null it allows doing some predefined
	 * actions instead of throwing Null Pointer Exception.
	 */
	public static void main(String[] args) {
		//Creation of Optional Object:
		//1. Returns an Empty Optional Instance, no value is present for this Optional
		Optional<String> optional = Optional.empty();
		
		//2. Returns an Optional describing the given non-null value:
		String str = "Hello";
		Optional<String> stringOptional = Optional.of(str);
		
		//3. Returns an Optional describing the given value if non-null,
		//otherwise returns an empty Optional
		String nullStr = null;
		Optional<String> stringOpt = Optional.ofNullable(nullStr);
		
		
		//Optional<T> usage:
		//Before Java-8:
		//1.
//		List<String> list = getList();
//		List<String> listOpt = list==null? new ArrayList<>() : list;
		//In Java-8;
		List<String> listOpts = Optional.ofNullable(getList()).orElseGet(() -> new ArrayList<String>());
		
		System.out.println("List Opts is: "+listOpts);
		
		//2.
		//Lets say we have a Method which returns a User which might be null,
		//this User has an Address field which again might be null,
		//this Address field has a String Street, which also might be null.
		//What we need to do is, if everything is not null,
		//then get the value of Street field for the User, else return "not specified":  
		//Prior to Java-8
		String street = "not specified";
		User ancientUser = getUser();
		if (ancientUser!=null) {
			if (ancientUser.getAddress()!=null) {
				if (ancientUser.getAddress().getStreet()!=null)
					street = ancientUser.getAddress().getStreet();
				
			}
		}
		
		System.out.println("User Street is: "+street);
		
		//With Java-8:
		Optional<User> user = Optional.ofNullable(getUser());
		//Down here if any of the methods returns a null,
		//the 'map' method would return an empty Optional,
		//which will lead to 'orElse' method getting executed:
		String newStreet = user.map(User::getAddress).
								map(Address::getStreet).
								orElse("not specified");
		
		System.out.println("Java-8 User Street is: "+newStreet);
		
		//3.
		//Lets assume our getters return Optional<T>, in that case we will need to use flatMap:
		Optional<User> optionalUser = getOptUser();
		String optionalStreet = optionalUser.
				flatMap(User::getOptAddress).
				flatMap(Address::getOptStreet).
				orElse("not specified");
		
		System.out.println("Java-8 Optional User Street is: "+optionalStreet);
		
		//4.
		//Changing the Null Pointer Exception with some other(or Custom) Exception:
		//Prior to Java-8:
		String value = null;
		String result="";
		try {
			result = value.toUpperCase();
		} catch(NullPointerException npe) {
			throw new IllegalArgumentException("Invalid value");
		}
		
		//With Java-8:
		Optional<String> optValue = Optional.ofNullable(value);
		result = optValue.orElseThrow(IllegalArgumentException::new).toUpperCase();
		
		System.out.println("Result is: "+result);
	}
	
	public static List<String> getList() {
		if ((int)(Math.random()*10)>4)
			return new ArrayList<>(Arrays.asList("Hello", "Hi"));
		else
			return null;
	}
	
	public static Optional<List<String>> getJava8List() {
		Optional<List<String>> returnValue;
		
		if ((int)(Math.random()*10)>0)
			returnValue = Optional.of(new ArrayList<>(Arrays.asList("Hello", "Hi")));
		else
			returnValue = Optional.empty();
		
		return returnValue;
	}
	
	public static User getUser() {
		int userRandom = (int)(Math.random()*10);
		int addressRandom = (int)(Math.random()*10);
		int streetRandom = (int)(Math.random()*10);
		
		if (userRandom>4) {
			if (addressRandom>1) {
				if (streetRandom>3) {
					return new User("Ravi", new Address("A-219", "Basant Kunj", "Alwar", "301001"));
				} else {
					return new User("Abhay", new Address("1904", null, "Khairtal", "301001"));
				}
			} else {
				return new User("Biswa");
			}
		} else
			return null;
	}
	
	public static Optional<User> getOptUser() {
		int userRandom = (int)(Math.random()*10);
		int addressRandom = (int)(Math.random()*10);
		int streetRandom = (int)(Math.random()*10);
		
		if (userRandom>4) {
			if (addressRandom>1) {
				if (streetRandom>3) {
					return Optional.of(new User("Ravi", new Address("A-219", "Basant Kunj", "Alwar", "301001")));
				} else {
					return Optional.of(new User("Abhay", new Address("1904", null, "Khairtal", "301001")));
				}
			} else {
				return Optional.of(new User("Biswa"));
			}
		} else
			return Optional.empty();
	}
}
