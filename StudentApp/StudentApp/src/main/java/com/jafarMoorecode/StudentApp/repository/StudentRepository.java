package com.jafarMoorecode.StudentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jafarMoorecode.StudentApp.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
