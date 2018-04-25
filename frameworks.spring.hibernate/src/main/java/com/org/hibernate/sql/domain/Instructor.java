package com.org.hibernate.sql.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Instructor")
public class Instructor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@OneToOne(cascade=CascadeType.ALL)
	private InstructorDetails details;

	@OneToMany(cascade=CascadeType.ALL,
			mappedBy="ins")
	private List<Course> courses ; 
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public InstructorDetails getDetails() {
		return details;
	}

	public void setDetails(InstructorDetails details) {
		this.details = details;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String name) {
		this.firstName = name;
	}

	public void addCourses(Course course) {
		
		if(courses==null) {
			courses = new ArrayList<>();
		}
		
		course.setIns(this);
		courses.add(course);
		
	}
	
}
