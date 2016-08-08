/**
 * 
 */
package com.dineshonjava.microservices.web;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Dinesh.Rajput
 *
 */
@JsonRootName("Student")
public class Student {
	
	Long id;
	
	String name;
	
	String email;
	
	String course;
	
	String college;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email
				+ ", course=" + course + ", college=" + college + "]";
	}

}
