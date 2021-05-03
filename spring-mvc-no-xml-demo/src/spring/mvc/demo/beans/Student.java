package spring.mvc.demo.beans;

public class Student {
	
	private String firstName;
	private String lastName;
	
	public Student() {
		
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public String toString() {
		return firstName+" "+lastName;
	}
	
}