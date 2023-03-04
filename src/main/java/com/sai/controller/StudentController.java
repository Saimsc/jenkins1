package com.sai.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.bean.Student;

@RestController

@RequestMapping("/api")
public class StudentController {

	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return List.of(new Student(1,"sanjeev","java"),
				new Student(2,"sai","python"));
	}	
		
	
	@GetMapping("/students/1")
	public Student getStudentDetaails() {
		return new Student(1,"sai","java");
	}
}
