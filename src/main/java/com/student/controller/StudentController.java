package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.exception.StudentNotFoundException;
import com.student.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping(value="/insert")
	public String insertStudent(@RequestBody Student student) {
		studentService.insertData(student);
		return "Inserted Record"; 
	}
	
	
	@GetMapping(value="/retrieveAll")
	public Iterable<Student> retrieveAllData() {
		return studentService.getAllData();
	}
	
	@GetMapping(value="/retrieveById/{sid}")
	public ResponseEntity<Student> retrieveById(@PathVariable("sid") Integer studentId) throws StudentNotFoundException {
		 //studentService.getStudentById(studentId);
		 return ResponseEntity.ok(studentService.getStudentById(studentId));
	}
	

}
