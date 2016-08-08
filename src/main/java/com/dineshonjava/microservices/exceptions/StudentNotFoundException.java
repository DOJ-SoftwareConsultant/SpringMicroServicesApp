/**
 * 
 */
package com.dineshonjava.microservices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Allow the controller to return a 404 if a student record is not found by simply
 * throwing this exception. The @ResponseStatus causes Spring MVC to return a
 * 404 instead of the usual 500.
 * @author Dinesh.Rajput
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7444402131685110607L;
	
	public StudentNotFoundException(String id) {
		super("No such student with id : " + id);
	}

}
