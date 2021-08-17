package com.learning.spring_security_demo_complete.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.learning.spring_security_demo_complete.validation.FieldMatch;
import com.learning.spring_security_demo_complete.validation.ValidEmail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@FieldMatch.List({
	@FieldMatch(first="password", second="matchingPassword",
			message = "The Password Fields must match")
})
public class CrmUser {
	
	@NotNull(message="is required!")
	@Size(min=1, message="is required!")
	private String userName;
	
	@NotNull(message="is required!")
	@Size(min=1, message="is required!")
	private String password;
	
	@NotNull(message="is required!")
	@Size(min=1, message="is required!")
	private String matchingPassword;
	
	@NotNull(message="is required!")
	@Size(min=1, message="is required!")
	private String firstName;
	
	@NotNull(message="is required!")
	@Size(min=1, message="is required!")
	private String lastName;
	
	@ValidEmail
	@NotNull(message="is required!")
	@Size(min=1, message="is required!")
	private String email;
	
	@NotNull(message="is required!")
	@Size(min=1, message="is required!")
	private String formRole;
	
}