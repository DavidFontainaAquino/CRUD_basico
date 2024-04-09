package com.dfont.crud.services;

import java.util.List;

import com.dfont.crud.entities.Student;

public interface StudentService {

	public List<Student> getAllStudents();
	public void addStudent(Student student);
}
