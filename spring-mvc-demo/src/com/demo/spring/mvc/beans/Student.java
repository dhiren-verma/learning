package com.demo.spring.mvc.beans;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Student {
	
	private String firstName;
	private String lastName;
	private String standard;
	private String favoriteSubject;
	
	//Can use either an Array or a List/Set for CheckBox Multiple Option Select Binding: 
//	private String[] hobbies;
	private Set<String> hobbies;
	
	//If need to populate Select Box from the Bean passed in Model in JSP Page:
	//This Data can be populated either as shown, or from a File-system, Web-Service, DB, etc:
	private final Map<String, String> standardOptions;
	
	
	public Student() {
		standardOptions = new LinkedHashMap<String, String>();
		
		standardOptions.put("1st", "First");
		standardOptions.put("2nd", "Second");
		standardOptions.put("3rd", "Third");
		standardOptions.put("4th", "Fourth");
		standardOptions.put("5th", "Fifth");
		standardOptions.put("6th", "Sixth");
		standardOptions.put("7th", "Seventh");
		standardOptions.put("8th", "Eighth");
		standardOptions.put("9th", "Ninth");
		standardOptions.put("10th", "Tenth");
		standardOptions.put("11th", "Eleventh");
		standardOptions.put("12th", "Twelfth");
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getStandard() {
		return standard;
	}
	
	public void setStandard(String standard) {
		this.standard = standard;
	}
	
	public String getFavoriteSubject() {
		return favoriteSubject;
	}
	
	public void setFavoriteSubject(String favoriteSubject) {
		this.favoriteSubject = favoriteSubject;
	}
	
//	public String[] getHobbies() {
//		return hobbies;
//	}
	
	public Set<String> getHobbies() {
		return hobbies;
	}
	
//	public void setHobbies(String[] hobbies) {
//		this.hobbies = hobbies;
//	}
	
	public void setHobbies(Set<String> hobbies) {
		this.hobbies = hobbies;
	}
	
	//If need to populate Select Box from the Bean passed in Model in JSP Page:
	public Map<String, String> getStandardOptions() {
		return standardOptions;
	}
	
	@Override
	public String toString() {
		StringBuilder responseString = new StringBuilder();
		
		responseString.append(firstName);
		responseString.append(" ");
		responseString.append(lastName);
		responseString.append(" from ");
		responseString.append(standard);
		responseString.append(" Standard\n");
		responseString.append("Your Favorite Subject is: ");
		responseString.append(favoriteSubject);
		responseString.append("\n");
		
//		switch(hobbies.length) {
//			case 0:
//				responseString.append(" but You have No Hobby!");
//				break;
//			case 1:
//				responseString.append(" & Your Hobby is:\n");
//				break;
//			default:
//				responseString.append(" & Your Hobbies are:\n");
//			
//		}
//
//		Arrays.stream(hobbies).
//		forEach(hobby -> responseString.append("*").append(hobby).append("\n"));
		
		switch(hobbies.size()) {
			case 0:
				responseString.append("but You have No Hobby!");
				break;
			case 1:
				responseString.append("& Your Hobby is:\n");
				break;
			default:
				responseString.append("& Your Hobbies are:\n");
			
		}
		
		hobbies.forEach(hobby -> responseString.append("*").append(hobby).append("\n"));
		
		return responseString.toString();
	}
	
}