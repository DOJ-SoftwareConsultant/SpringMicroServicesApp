/**
 * 
 */
package com.dineshonjava.microservices.employee.service;

import java.util.List;

import com.dineshonjava.microservices.employee.Employee;

/**
 * Exposing methods for CRUD operation on the Employee DB
 * @author Dinesh.Rajput
 *
 */
public interface IEmployeeService {
	//Create
	Employee createEmployee(Employee employee);
	//Read
	Employee findEmployeeById(Long id); 
	//Update
	Employee updateEmployee(Employee employee); 
	//Delete
	void deleteEmployee(Employee employee); 
	//Read All
	List<Employee> findAllEmployees();
}
