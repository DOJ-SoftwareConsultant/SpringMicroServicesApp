/**
 * 
 */
package com.dineshonjava.microservices.web;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Dinesh.Rajput
 *
 */
@JsonRootName("Employee")
public class Employee {
	
	Long id;
	
	String name;
	
	String email;
	
	String designation;
	
	String organization;

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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email
				+ ", designation=" + designation + ", organization="
				+ organization + "]";
	}
	
	
}
