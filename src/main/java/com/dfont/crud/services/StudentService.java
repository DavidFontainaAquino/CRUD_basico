package com.dfont.crud.services;

import java.util.List;

import com.dfont.crud.dto.StudentDTO;

public interface StudentService {

	public List<StudentDTO> getAllStudents();
	public void addStudent(StudentDTO studentDto);
}
