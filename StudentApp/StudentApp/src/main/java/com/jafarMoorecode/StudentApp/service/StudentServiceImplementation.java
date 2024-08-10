package com.jafarMoorecode.StudentApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jafarMoorecode.StudentApp.model.Student;
import com.jafarMoorecode.StudentApp.repository.StudentRepository;

@Service
public class StudentServiceImplementation implements Studentservice {
	
	@Autowired
	private StudentRepository studentrepository;

	@Override
	public Student saveStudent(Student student) {
		return studentrepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentrepository.findAll();
	}

	@Override
	public void deleteAll () {
	    studentrepository.deleteAll();
	    return;
	}

	public Optional<Student> FindById(Integer id) {
		return studentrepository.findById(id);
	}

	@Override
	public Optional<Student> Update(Optional<Student> studentOptional, Integer id) {
	    if (studentOptional.isPresent()) {
	        Student newStudentData = studentOptional.get();
	        
	        Optional<Student> existingStudentOptional = studentrepository.findById(id);
	        if (existingStudentOptional.isPresent()) {
	            Student existingStudent = existingStudentOptional.get();
	            
	            // Update the existing student with new data
	            existingStudent.setName(newStudentData.getName());
	            existingStudent.setAddress(newStudentData.getAddress());
	            
	            // Save the updated student back to the repository
	            studentrepository.save(existingStudent);
	            
	            // Return the updated student
	            return Optional.of(existingStudent);
	        }
	    }
	    
	    // If the studentOptional does not have a value or the student is not found, return an empty Optional
	    return Optional.empty();
	}

	@Override
	public void Delete(Integer id) {
		 studentrepository.deleteById(id);
	}


	
	
	
	
	

	
	
	

}
