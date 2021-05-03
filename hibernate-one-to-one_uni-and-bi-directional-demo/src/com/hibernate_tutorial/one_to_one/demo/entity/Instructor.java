package com.hibernate_tutorial.one_to_one.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="instructor")
@Getter @Setter @NoArgsConstructor @ToString
public class Instructor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
//	//To apply multiple cascade options, but not all:
//	@OneToOne(cascade= {CascadeType.DETACH,
//			CascadeType.MERGE,
//			CascadeType.PERSIST,
//			CascadeType.REMOVE})
	@JoinColumn(name="instructor_detail_id")
	@ToString.Exclude
	private InstructorDetail instructorDetail;
	
	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
}