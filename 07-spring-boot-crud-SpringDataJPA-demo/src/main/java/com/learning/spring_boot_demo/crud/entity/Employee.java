package com.learning.spring_boot_demo.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@EqualsAndHashCode.Exclude
	@Column(name = "first_name")
	private String firstName;
	
	@EqualsAndHashCode.Exclude
	@Column(name = "last_name")
	private String lastName;
	
	@EqualsAndHashCode.Exclude
	@Column(name = "email")
	private String email;
	
}
