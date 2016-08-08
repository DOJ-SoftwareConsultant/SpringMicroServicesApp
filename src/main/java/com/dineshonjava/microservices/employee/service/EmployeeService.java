/**
 * 
 */
package com.dineshonjava.microservices.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dineshonjava.microservices.employee.Employee;
import com.dineshonjava.microservices.employee.EmployeeRepository;

/**
 * Implementation of all the CRUD methods for Employee table
 * @author Dinesh.Rajput
 *
 */
@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository; 
	
	/** Creating employee data in the employee table
	 * @param employee object
	 * @return employee object
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	/** Reading employee data for specific employee id
	 * @param employee id
	 * @return employee object
	 */
	@Transactional(readOnly=true)
	@Override
	public Employee findEmployeeById(Long id) {
		return employeeRepository.findOne(id);
	}

	/** Updating employee data for specific employee ids
	 * @param employee object
	 * @return employee object
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	/** Deleting employee for specific employee id
	 * @param employee object
	 * @return void
	 */
	@Override
	public void deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
	}
	
	/** fetch list employees
	 * @return list of employee object
	 */
	@Override
	public List<Employee> findAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

}
