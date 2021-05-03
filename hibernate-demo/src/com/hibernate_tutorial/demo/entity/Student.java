package com.hibernate_tutorial.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.hibernate_tutorial.util.parser.DateTimeUtil;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="student")
//This below is Project Lombok:
@Getter @Setter @NoArgsConstructor// @ToString
public class Student {
	
	@Id
	//This below Generated Value policy is equivalent to MySQL Auto-increment Policy:
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
//	//For limiting The Access Modifier of a Getter/Setter while using Project Lombok:
//	@Column(name="id")
//	private @Id @Setter(AccessLevel.PROTECTED) int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	public Student(String firstName, String lastName, String email, Date dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}
	
	@Override
	public String toString() {
		return "Student [ID=" + id + ", First Name=" + firstName + ", Last Name=" + lastName + ", E-Mail=" + email
				+ ", Date Of Birth=" + DateTimeUtil.formatDate(dateOfBirth) + "]";
	}
	
}