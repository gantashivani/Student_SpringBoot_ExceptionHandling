package com.student.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.exception.StudentNotFoundException;
import com.student.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepo;
	
	public Student insertData(Student student) {
		return studentRepo.save(student);
	}
		
	public Iterable<Student> getAllData() {
			return studentRepo.findAll();
	}
	
	public Student getStudentById(Integer studentId) throws StudentNotFoundException {
		return studentRepo.findById(studentId).orElseThrow(() -> new StudentNotFoundException("No StudentFound with the StudentID provided"));
	}
	
	

}
