package learning.java8;

import java.util.Optional;

public class Address {

	private final String flatNo;
	private final String street;
	private final String city;
	private final String pincode;
	
	public Address() {
		flatNo = null;
		street = null;
		city = null;
		pincode = null;
	}
	
	public Address(String flatNo, String street, String city, String pincode) {
		this.flatNo = flatNo;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	}
	
	public String getFlatNo() {
		return flatNo;
	}
	
	public Optional<String> getOptFlatNo() {
		return Optional.ofNullable(flatNo);
	}
	
	public String getStreet() {
		return street;
	}

	public Optional<String> getOptStreet() {
		return Optional.ofNullable(street);
	}
	
	public String getCity() {
		return city;
	}
	
	public Optional<String> getOptCity() {
		return Optional.ofNullable(city);
	}
	
	public String getPincode() {
		return pincode;
	}
	
	public Optional<String> getOptPincode() {
		return Optional.ofNullable(pincode);
	}
	
}