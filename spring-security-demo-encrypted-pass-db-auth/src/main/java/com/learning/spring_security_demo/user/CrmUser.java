package com.learning.spring_security_demo.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Added for being able to Create New User(s):
@NoArgsConstructor
@Getter
@Setter
public class CrmUser {
	
	@NotNull(message = "is required!")
	@Size(min=1, message = "is required!")
	private String userName;
	
	@NotNull(message = "is required!")
	@Size(min=1, message = "is required!")
	private String password;
	
	private String formRole;
	
}
