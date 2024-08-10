package com.jafarMoorecode.StudentAppTeacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
	@Autowired
	private TeacherRepository teacherrepository;
	
	public void addTecher(Teacher teacher) {
		teacherrepository.save(teacher);
	}
	
	public void deleteTeacher(Integer id) {
		teacherrepository.deleteById(id);;
	}
	
	public void updateteacher (Integer id , Teacher teacher) {
		teacherrepository.save(teacher);
	}
	
}
