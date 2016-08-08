/**
 * 
 */
package com.dineshonjava.microservices.student.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dineshonjava.microservices.exceptions.StudentNotFoundException;
import com.dineshonjava.microservices.student.Student;
import com.dineshonjava.microservices.student.service.IStudentService;

/**
 * A RESTFul controller for accessing and updating student information.
 * @author Dinesh.Rajput
 *
 */
@RestController
public class StudentController {
	
protected Logger logger = Logger.getLogger(StudentController.class.getName());
	
	@Autowired
	protected IStudentService studentService;
	
	/**
	 * Create an student record.
	 * 
	 * @param student object
	 * @return The Student after creation.
	 * 
	 */
	@RequestMapping("/students/create")
	public Student createStudent(Student student) {
		logger.info("student-service createStudent() invoked: " + student);
		student = studentService.createStudent(student);
		logger.info("student-service createStudent() found: " + student);
		return student;
	}
	
	/**
	 * Fetch an student record with the specified student id.
	 * 
	 * @param studentId
	 * @return The Student if found.
	 * @throws StudentNotFoundException
	 *             If the student id is not recognized.
	 */
	@RequestMapping("/students/{studentId}")
	public Student studentById(@PathVariable("studentId") String studentId) {
		logger.info("student-service studentById() invoked: " + studentId);
		Student student = studentService.findStudentById(Long.valueOf(studentId));
		logger.info("student-service studentById() found: " + student);
		if (student == null)
			throw new StudentNotFoundException(studentId);
		else {
			return student;
		}
	}
	
	/**
	 * Update an student email/course/college record with the specified student id.
	 * @param studentId
	 * @return The Student if found.
	 * @throws StudentNotFoundException
	 *             If the student id is not recognized.
	 */
	@RequestMapping("/students/update/{studentId}")
	public Student updateStudentById(@PathVariable("studentId") String studentId, 
			@RequestParam (required = false) String email, 
			@RequestParam (required = false) String course, 
			@RequestParam (required = false) String college) {
		logger.info("student-service updateStudentById() invoked: " + studentId);
		Student student = studentService.findStudentById(Long.valueOf(studentId));
		logger.info("student-service updateStudentById() found: " + student);
		if (student == null)
			throw new StudentNotFoundException(studentId);
		else {
			if(email != null){
				student.setEmail(email);
			}
			if(course != null){
				student.setCourse(course);
			}
			if(college != null){
				student.setCollege(college);
			}
			student = studentService.createStudent(student);
			return student;
		}
	}
	/**
	 * Delete a student record with the specified student id.
	 * 
	 * @param studentId
	 * @return The Student if found.
	 */
	@RequestMapping("/students/delete/{studentId}")
	public String deleteStudentById(@PathVariable("studentId") Long studentId) {
		logger.info("student-service studentById() invoked: " + studentId);
		Student student = new Student(studentId, null, null, null, null);
		studentService.deleteStudent(student);
		logger.info("student-service studentById() found: " + student);
		return studentId+" deleted successfully";
	}
}
