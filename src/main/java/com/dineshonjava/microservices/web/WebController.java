package com.dineshonjava.microservices.web;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Client controller, fetches Student and Employee info from the microservice via
 * {@link WebService}.
 * 
 * @author Dinesh Rajput
 */
@Controller
public class WebController {

	@Autowired
	protected WebService webService;

	protected Logger logger = Logger.getLogger(WebController.class
			.getName());

	public WebController(WebService webService) {
		this.webService = webService;
	}

	@RequestMapping("/home")
	public String goHome() {
		return "home";
	}

	@RequestMapping("/students/{id}")
	public String studentById(Model model,
			@PathVariable("id") String id) {
		logger.info("web-service studentById() invoked: " + id);
		Student student = webService.findByStudentId(id);
		logger.info("web-service studentById() found: " + student);
		model.addAttribute("student", student);
		return "student";
	}
	
	@RequestMapping("/students/")
	public String findAllStudents(Model model) {
		logger.info("web-service findAllStudents() invoked");
		List<Student> students = webService.findAllStudents();
		logger.info("web-service findAllStudents() found: " + students);
		if (students != null)
			model.addAttribute("students", students);
		return "students";
	}
	
	@RequestMapping("/employees/{id}")
	public String employeeById(Model model,
			@PathVariable("id") String id) {
		logger.info("web-service employeeById() invoked: " + id);
		Employee employee = webService.findByEmployeeId(id);
		logger.info("web-service employeeById() found: " + employee);
		model.addAttribute("employee", employee);
		return "employee";
	}

	@RequestMapping("/employees/")
	public String findAllEmployees(Model model) {
		logger.info("web-service findAllEmployees() invoked");
		List<Employee> employees = webService.findAllEmployees();
		logger.info("web-service findAllEmployees() found: " + employees);
		if (employees != null)
			model.addAttribute("employees", employees);
		return "employees";
	}

}
