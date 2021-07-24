package com.hibernate_tutorial.many_to_many.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="instructor_detail")
@Getter @Setter @NoArgsConstructor @ToString
public class InstructorDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	//This below addition is only for Bi-Directional Relationship:
	@OneToOne(mappedBy="instructorDetail", cascade=CascadeType.ALL)
	@ToString.Exclude
	private Instructor instructor;
	
	public InstructorDetail(String youtTubeChannel, String hobby) {
		this.youtubeChannel = youtTubeChannel;
		this.hobby = hobby;
	}
	
}