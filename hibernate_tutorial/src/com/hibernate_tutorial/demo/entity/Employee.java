package com.hibernate_tutorial.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="employee")
@Getter @Setter @NoArgsConstructor @ToString
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name", length=20, nullable=false)
	private String firstName;
	
	@Column(name="last_name", length=20, nullable=false)
	private String lastName;
	
	@Column(name="company", length=50, nullable=false)
	private String company;
	
	public Employee(String firstName, String lastName, String company) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
	}
	
}