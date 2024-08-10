package com.jafarMoorecode.StudentApp.service;

import java.util.List;
import java.util.Optional;

import com.jafarMoorecode.StudentApp.model.Student;

public interface Studentservice {
	
	public Student saveStudent(Student student);
	
	public List<Student> getAllStudents();

	public void deleteAll();
	

	Optional<Student> FindById(Integer Id);
	

	Optional<Student> Update(Optional<Student> student, Integer id);
	
	 public void Delete(Integer id);
	
	
}
