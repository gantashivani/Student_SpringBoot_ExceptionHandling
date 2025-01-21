package com.student.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.exception.StudentAlreadyExistsException;
import com.student.exception.StudentNotFoundException;
import com.student.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepo;
	
	public Student insertData(Student student) throws StudentAlreadyExistsException {
		Optional<Student> validateStudent = studentRepo.findById(student.getStudentId());
		
		if(validateStudent != null) {
		 throw new StudentAlreadyExistsException("Student data already exists");
		}
		return studentRepo.save(student);
	}
		
	public Iterable<Student> getAllData() {
			return studentRepo.findAll();
	}
	
	public Student getStudentById(Integer studentId) throws StudentNotFoundException {
		return studentRepo.findById(studentId).orElseThrow(() -> new StudentNotFoundException("No StudentFound with the StudentID provided"));
	}
	
	

}
