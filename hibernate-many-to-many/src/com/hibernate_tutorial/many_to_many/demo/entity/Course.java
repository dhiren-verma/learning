package com.hibernate_tutorial.many_to_many.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Concept used here is that an Instructor can have Many Courses,
 * though a Course cannot have more than 1 Instructor
 * Also a Course can have many Reviews but a Review cannot have more than 1 Course 
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
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) 
	@JoinColumn(name="instructor_id")
	@ToString.Exclude
	private Instructor instructor;
	
	//If we delete a Course, we want all the associated Reviews to be deleted simultaneously:
	@OneToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	//Special Case situation in case of OneToMany Uni-Directional Relationship
	@JoinColumn(name="course_id")
	@ToString.Exclude
	private List<Review> reviews;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH,
					CascadeType.MERGE,
					CascadeType.PERSIST,
					CascadeType.REFRESH})
	@JoinTable(name="course_student",
			joinColumns = @JoinColumn(name="course_id"),
			inverseJoinColumns = @JoinColumn(name="student_id"))
	@ToString.Exclude
	private List<Student> students;
	
	public Course(String title) {
		this.title = title;
	}
	
	//Convenience Method to add new Review:
	public void addReview(Review review) {
		if (reviews==null)
			reviews = new ArrayList<>();
		
		reviews.add(review);
	}
	
	//Convenience method to add new Student:
	public void enrollStudent(Student newStudent) {
		if (students==null)
			students = new ArrayList<>();
		
		students.add(newStudent);
	}
	
}
