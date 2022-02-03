package learning.java8;

import java.util.Optional;

public class User {
	
	private String userName;
	private Address address;
	
	User(String userName) {
		this.userName = userName;
		address = null;
	}
	
	User(String userName, Address address) {
		this.userName = userName;
		this.address = address;
	}
	
	String getUserName() {
		return userName;
	}
	
	Address getAddress() {
		return address;
	}
	
	Optional<Address> getOptAddress() {
		return Optional.ofNullable(address);
	}
	
	String getFormattedName() {
		StringBuilder builder = new StringBuilder();
		
		if (!userName.isEmpty()) {
			String[] words = userName.split(" ");
			
			for (int i = 0; i < words.length; i++) {
			    String[] characters = words[i].split("");
			    
			    if (!builder.toString().isEmpty())
			    	builder.append(" ");
			    
			    for (int j=0; j<characters.length; j++) {
			    	if (j==0)
			    		builder.append(characters[j].toUpperCase());
			    	else
			    		builder.append(characters[j].toLowerCase());
			    }
			    
			}
		}
		
		return builder.toString();
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + "]";
	}
	
}
