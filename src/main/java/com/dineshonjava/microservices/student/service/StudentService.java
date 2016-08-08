/**
 * 
 */
package com.dineshonjava.microservices.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dineshonjava.microservices.student.Student;
import com.dineshonjava.microservices.student.StudentRepository;

/**
 * Implementation of all the CRUD methods for Student table
 * @author Dinesh.Rajput
 *
 */
@Service
public class StudentService implements IStudentService {
	
	@Autowired
	StudentRepository studentRepository; 
	
	/** Creating student data in the student table
	 * @param student object
	 * @return student object
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	/** Reading student data for specific student id
	 * @param student id
	 * @return student object
	 */
	@Transactional(readOnly=true)
	@Override
	public Student findStudentById(Long id) {
		return studentRepository.findOne(id);
	}

	/** Updating student data for specific student ids
	 * @param student object
	 * @return student object
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	/** Deleting student for specific student id
	 * @param student object
	 * @return void
	 */
	@Override
	public void deleteStudent(Student student) {
		studentRepository.delete(student);
	}
	
	/** fetch list students
	 * @return list of student object
	 */
	@Override
	public List<Student> findAllStudents() {
		return (List<Student>) studentRepository.findAll();
	}

}
