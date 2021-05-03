package com.hibernate_tutorial.one_to_many.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	@JoinColumn(name="instructor_detail_id")
	@ToString.Exclude
	private InstructorDetail instructorDetail;
	
	//If we delete a Instructor, and don't want to delete the associated Courses:
	@OneToMany(mappedBy="instructor", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@ToString.Exclude
	private List<Course> courses;
	
	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	//Convenience method for Bi-Directional Relationship:
	public void addCourse(Course course) {
		if (courses==null)
			courses = new ArrayList<>();
		
		course.setInstructor(this);
		
		courses.add(course);
	}
	
}