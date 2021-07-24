package com.hibernate_tutorial.eager_VS_lazy.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Concept used here is that an Instructor can have Many Courses,
 * though a Course cannot have more than 1 Instructor
 * 
 * @author Dhirendra
 *
 */
@Entity
@Table(name="course")
@Getter @Setter @NoArgsConstructor @ToString
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	//If we delete a Course, we don't want to delete associated Instructor:
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) 
	@JoinColumn(name="instructor_id")
	@ToString.Exclude
	private Instructor instructor;
	
	public Course(String title) {
		this.title = title;
	}
	
}
