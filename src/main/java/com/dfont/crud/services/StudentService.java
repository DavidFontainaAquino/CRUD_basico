package com.dfont.crud.services;

import java.util.List;
import java.util.Optional;

import com.dfont.crud.dto.StudentDTO;

public interface StudentService {

	public List<StudentDTO> getAllStudents();
	public StudentDTO saveStudent(StudentDTO studentDto);
	public Optional<StudentDTO> getStudentById(Long id);
	public StudentDTO updateStudent(StudentDTO studentDTO);
	public void deleteStudent(Long id);
	public Boolean studentExistById(Long id);
}
