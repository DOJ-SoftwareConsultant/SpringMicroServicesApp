/**
 * 
 */
package com.dineshonjava.microservices.employee.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dineshonjava.microservices.employee.Employee;
import com.dineshonjava.microservices.employee.service.IEmployeeService;
import com.dineshonjava.microservices.exceptions.EmployeeNotFoundException;

/**
 * A RESTFul controller for accessing and updating employee information.
 * @author Dinesh.Rajput
 *
 */
@RestController
public class EmployeeController {
	
	protected Logger logger = Logger.getLogger(EmployeeController.class.getName());
	
	@Autowired
	protected IEmployeeService employeeService;
	
	/**
	 * Create an employee record.
	 * 
	 * @param employee object
	 * @return The employee after creation.
	 * 
	 */
	@RequestMapping("/employees/create")
	public Employee createEmployee(Employee employee) {
		logger.info("employee-service createEmployee() invoked: " + employee);
		employee = employeeService.createEmployee(employee);
		logger.info("employee-service createEmployee() found: " + employee);
		return employee;
	}
	
	/**
	 * Fetch an employee record with the specified employee number.
	 * 
	 * @param employeeId
	 * @return The Employee if found.
	 * @throws EmployeeNotFoundException
	 *             If the employee id is not recognized.
	 */
	@RequestMapping("/employees/{employeeId}")
	public Employee employeeById(@PathVariable("employeeId") String employeeId) {
		logger.info("employee-service employeeById() invoked: " + employeeId);
		Employee employee = employeeService.findEmployeeById(Long.valueOf(employeeId));
		logger.info("employee-service employeeById() found: " + employee);
		if (employee == null)
			throw new EmployeeNotFoundException(employeeId);
		else {
			return employee;
		}
	}
	/**
	 * Update an Employee email/course/college record with the specified Employee id.
	 * @param employeeId
	 * @return The Employee if found.
	 * @throws EmployeeNotFoundException
	 *             If the employee id is not recognized.
	 */
	@RequestMapping("/employees/update/{employeeId}")
	public Employee updateEmployeeById(@PathVariable("employeeId") String employeeId, 
			@RequestParam (required = false) String email, 
			@RequestParam (required = false) String designation, 
			@RequestParam (required = false) String organization) {
		logger.info("employee-service updateEmployeeById() invoked: " + employeeId);
		Employee employee = employeeService.findEmployeeById(Long.valueOf(employeeId));
		logger.info("employee-service updateEmployeeById() found: " + employee);
		if (employee == null)
			throw new EmployeeNotFoundException(employeeId);
		else {
			if(email != null){
				employee.setEmail(email);
			}
			if(designation != null){
				employee.setDesignation(designation);
			}
			if(organization != null){
				employee.setOrganization(organization);
			}
			employee = employeeService.createEmployee(employee);
			return employee;
		}
	}
	/**
	 * Delete a Employee record with the specified Employee id.
	 * 
	 * @param EmployeeId
	 * @return The Employee if found.
	 */
	@RequestMapping("/employees/delete/{employeeId}")
	public String deleteEmployeeById(@PathVariable("employeeId") Long employeeId) {
		logger.info("employee-service deleteEmployeeById() invoked: " + employeeId);
		Employee employee = new Employee(employeeId, null, null, null, null);
		employeeService.deleteEmployee(employee);
		logger.info("employee-service deleteEmployeeById() found: " + employee);
		return employeeId+" deleted successfully";
	}
}
