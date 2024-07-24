package com.demo.main.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.main.entity.Student;

import com.demo.main.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	public StudentService studentService;
	
	@PostMapping("/addStudent")
	
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		
		Student addStudent = studentService.addStudent(student);
		return new ResponseEntity<>(addStudent,HttpStatus.OK);
	}
	

//	@GetMapping("/getStudent/{studentId}")
//	public ResponseEntity<Student> getStudent(@PathVariable int studentId) throws StudentNotFoundException {
//		Student student = studentService.getStudent(studentId);
//		return new ResponseEntity<>(student,HttpStatus.ACCEPTED);
//	}
	
	@GetMapping("/getStudent/{studentId}")
	public Student getStudent(@PathVariable int studentId)  {
		Student student = studentService.getStudent(studentId);
		return student;
	}
	
	
	
	
	@PutMapping("/updateStudent/{studentId}")
	public ResponseEntity<Student> updateStudent(@PathVariable int studentId,@RequestBody Student student) throws Exception{
		Student updateStudent = studentService.updateStudent(studentId, student);
		return new ResponseEntity<>(updateStudent,HttpStatus.ACCEPTED);
	}


	@DeleteMapping("/deleteStudent/{studentId}")
	
	public ResponseEntity<String> deleteStudent(@PathVariable int studentId) throws Exception{
		String deleteStudent = studentService.deleteStudent(studentId);
		return new ResponseEntity<>(deleteStudent,HttpStatus.ACCEPTED);
	}
	
	
	
	  
}


	


