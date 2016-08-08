/**
 * 
 */
package com.dineshonjava.microservices.employee;

import org.springframework.data.repository.CrudRepository;

/**
 * Repository for Employee data implemented using Spring Data JPA.
 * @author Dinesh.Rajput
 *
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	/**
	 * Find an Employee with the specified Employee email id.
	 *
	 * @param email
	 * @return The Employee if found, null otherwise.
	 */
	Employee findByEmail(String email);
	
}
