package com.demo.main.service;



import com.demo.main.entity.Student;

public interface StudentService {

	public Student addStudent(Student student);
	
	public Student updateStudent(int studentId,Student student) throws Exception ;
	
	public Student getStudent(int studentId);
	
	
	
	public String deleteStudent(int studentId) throws Exception;
	
	
}
