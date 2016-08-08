/**
 * 
 */
package com.dineshonjava.microservices.student.service;

import java.util.List;

import com.dineshonjava.microservices.student.Student;

/**
 * Exposing methods for CRUD operation on the Student DB
 * @author Dinesh.Rajput
 *
 */
public interface IStudentService {
	//Create
	Student createStudent(Student student);
	//Read
	Student findStudentById(Long id); 
	//Update
	Student updateStudent(Student student); 
	//Delete
	void deleteStudent(Student student); 
	//Read All
	List<Student> findAllStudents();
}
