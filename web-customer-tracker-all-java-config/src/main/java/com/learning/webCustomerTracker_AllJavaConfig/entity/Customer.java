package com.learning.webCustomerTracker_AllJavaConfig.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.learning.webCustomerTracker_AllJavaConfig.validation.ValidEmail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull(message = "cannot be Null!")
	@Size(min = 1, max = 45, message = "invalid length, shouldn't be Empty and should be less than 45 characters!")
	@Pattern(regexp = "^[a-zA-Z]+", message = "invalid characters in First Name")
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull(message = "cannot be Null!")
	@Size(min = 1, max = 45, message = "invalid length, shouldn't be Empty and should be less than 45 characters!")
	@Pattern(regexp = "^[a-zA-Z]+", message = "invalid characters in Last Name")
	@Column(name = "last_name")
	private String lastName;
	
	@ValidEmail(message = "input a valid E-Mail")
	@Column(name = "email")
	private String email;
	
	public Customer(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
}