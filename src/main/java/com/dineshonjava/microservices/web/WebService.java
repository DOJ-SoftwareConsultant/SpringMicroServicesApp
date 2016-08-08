package com.dineshonjava.microservices.web;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Hide the access to the microservice inside this local service.
 * 
 * @author Dinesh Rajput
 */
@Service
public class WebService {

	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	protected String studentServiceUrl;
	
	protected String employeeServiceUrl;

	protected Logger logger = Logger.getLogger(WebService.class
			.getName());

	public WebService(String studentServiceUrl, String employeeServiceUrl) {
		this.studentServiceUrl = studentServiceUrl.startsWith("http") ? studentServiceUrl
				: "http://" + studentServiceUrl;
		this.employeeServiceUrl = employeeServiceUrl.startsWith("http") ? employeeServiceUrl
				: "http://" + employeeServiceUrl;
	}

	/**
	 * The RestTemplate works because it uses a custom request-factory that uses
	 * Ribbon to look-up the service to use. This method simply exists to show
	 * this.
	 */
	@PostConstruct
	public void demoOnly() {
		// Can't do this in the constructor because the RestTemplate injection
		// happens afterwards.
		logger.warning("The RestTemplate request factory is "
				+ restTemplate.getRequestFactory().getClass());
	}

	public Student findByStudentId(String studentId) {
		logger.info("findByStudentId() invoked: for " + studentId);
		return restTemplate.getForObject(studentServiceUrl + "/students/{studentId}",
				Student.class, studentId);
	}
	
	public List<Student> findAllStudents() {
		logger.info("findAllStudents() invoked");
		Student[] students = null;
		try {
			students = restTemplate.getForObject(studentServiceUrl
					+ "/students/", Student[].class);
		} catch (HttpClientErrorException e) { // 404
			// Nothing found
		}
		if (students == null || students.length == 0)
			return null;
		else
			return Arrays.asList(students);
	}
	
	public Employee findByEmployeeId(String employeeId) {
		logger.info("findByEmployeeId() invoked: for " + employeeId);
		return restTemplate.getForObject(employeeServiceUrl + "/employees/{employeeId}",
				Employee.class, employeeId);
	}

	public List<Employee> findAllEmployees() {
		logger.info("findAllEmployees() invoked");
		Employee[] employees = null;
		try {
			employees = restTemplate.getForObject(employeeServiceUrl
					+ "/employees/", Employee[].class);
		} catch (HttpClientErrorException e) { // 404
			// Nothing found
		}
		if (employees == null || employees.length == 0)
			return null;
		else
			return Arrays.asList(employees);
	}
}
