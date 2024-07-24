package com.demo.main.serviceImplementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.demo.main.entity.Student;

import com.demo.main.exception.StudentNotFoundException;
import com.demo.main.repository.StudentRepository;
import com.demo.main.service.StudentService;


@Service

public class StudentServiceImp implements StudentService {

	@Autowired
	public StudentRepository studentRepository;
	
	@Override
	public Student addStudent(Student student) {
		Student student1 = studentRepository.save(student);
		return student1;
	}


//	@Override
//	public Student getStudent(int studentId) throws Exception {
//		Student student2 = studentRepository.findById(studentId).orElseThrow(()-> new Exception("Student Id is not present..!!!"));
//		return student2;
//	}
	
	@Override
	public Student getStudent(int studentId) {
		Student student2 = studentRepository.findById(studentId).orElseThrow(()-> new 
				StudentNotFoundException("Student Id is not present : " + studentId));
		return student2;
		
	
		
	}
	
	
	
	@Override
	public Student updateStudent(int studentId, Student student) throws Exception {
		Student student2 = studentRepository.findById(studentId).orElseThrow(()-> new Exception("Student Id is not present..!!!"));
		student2.setAddress(student.getAddress());
		student2.setMarks(student.getMarks());
		Student student3 = studentRepository.save(student2);
		return student3;
	}
	
	@Override
	
	public String deleteStudent(int studentId) throws Exception {
		Student student2 = studentRepository.findById(studentId).orElseThrow(()-> new Exception("Student Id is not present..!!!"));
		studentRepository.delete(student2);
		return "Student Deleted Succesfully....!!!";
	}







	



}
