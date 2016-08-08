/**
 * 
 */
package com.dineshonjava.microservices.student;

import org.springframework.data.repository.CrudRepository;

/**
 * Repository for Student data implemented using Spring Data JPA.
 * @author Dinesh.Rajput
 *
 */
public interface StudentRepository extends CrudRepository<Student, Long>{
	
	/**
	 * Find an Student with the specified Student email id.
	 *
	 * @param email
	 * @return The Student if found, null otherwise.
	 */
	public Student findByEmail(String email);
}
