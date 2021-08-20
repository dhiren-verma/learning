package com.learning.spring_security_demo_thymeleaf.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.learning.spring_security_demo_thymeleaf.validation.FieldMatch;
import com.learning.spring_security_demo_thymeleaf.validation.ValidEmail;

import lombok.Data;

@Data
@FieldMatch.List({
	@FieldMatch(first="password",
			second="matchingPassword",
			message="Password fields must match!")
})
public class CrmUser {
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String userName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String password;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String matchingPassword;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;
	
	@ValidEmail
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String email;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String formRole;
	
}