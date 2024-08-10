package com.jafarMoorecode.StudentApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jafarMoorecode.StudentApp.model.Student;
import com.jafarMoorecode.StudentApp.service.Studentservice;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class controller {
	
	@Autowired
	private Studentservice studentService;
	
	@PostMapping("/add")
	public String add(@RequestBody Student student) {
		studentService.saveStudent(student);
		return "new Student is added";
	}
	
	@GetMapping("/getAll")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@DeleteMapping("/deleteAll")
	public String DeleteALLStudent () {
		studentService.deleteAll();
		return "Student is deleted";
	}
	
	@GetMapping("/get/{id}")
	public Optional<Student> Find(@PathVariable Integer id) {
		return studentService.FindById(id);
	}
	
	@PutMapping("/update/{id}")
	public Optional<Student> Update(@RequestBody Optional<Student> student ,@PathVariable Integer id){
		return studentService.Update( student, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void Delete(@PathVariable Integer id){
		 studentService.Delete(id);
	}
	
	
	
}
