package com.demo.spring.mvc.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.demo.spring.mvc.custom.validation.CourseCode;
import com.demo.spring.mvc.custom.validation.MultiCourseCode;

public class Customer {
	
	private String firstName;
	
	//We are adding Not Null & Minimum Size Validation Rules to LastName:
	@NotNull(message="cannot be Null!")
	@Size(min=1, message="is required!")
	private String lastName;
	
	//To make an int field required, add @NotNull Annotation & convert data-type
	//from Primitive to Wrapper(int - Integer)
	@Min(value=0, message="greater than or equal to '0'")
	@Max(value=10, message="smaller than or equal to '10'")
	private int freePasses;
	
	//If entered then must have 5 Characters/Digits:
	@Pattern(regexp="[a-zA-Z0-9]{5}",  message="only 5 chars/digits")
	private String postalCode;
	
//	@CourseCode(value="CS", message="must start with CS")
	@MultiCourseCode(value={"JAVA","CS"}, message="must start with JAVA or CS")
	private String courseCode;
	
	
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
	
	public int getFreePasses() {
		return freePasses;
	}
	
	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
}