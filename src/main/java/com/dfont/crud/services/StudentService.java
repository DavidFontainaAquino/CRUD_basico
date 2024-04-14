package com.dfont.crud.services;

import java.util.List;

import com.dfont.crud.dto.StudentDTO;
import com.dfont.crud.entities.Student;

public interface StudentService {

	public List<StudentDTO> getAllStudents();
	public Student saveStudent(StudentDTO studentDto);
}
