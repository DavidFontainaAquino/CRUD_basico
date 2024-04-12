package com.dfont.crud.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfont.crud.dto.StudentDTO;
import com.dfont.crud.entities.Student;
import com.dfont.crud.repositories.StudentRepository;

@Service
public class StudentServiceImp implements StudentService {
	
	@Autowired
	private StudentRepository repository;
	private static Student student = new Student();
	private static StudentDTO studentDTO =new StudentDTO();
	
	@Override
	public List<StudentDTO> getAllStudents() {
		List<StudentDTO> listDTO = new ArrayList<>();
		for (Student student : repository.findAll()) {
			listDTO.add(daoToDto(student));
		}
		return listDTO;
	}

	@Override
	public void addStudent(StudentDTO studentDto) {
		repository.save(dtoToDao(studentDto));
	}
	
	private static  StudentDTO daoToDto(Student stud) {
		
		studentDTO.setId(stud.getId());
		studentDTO.setName(stud.getName());
		studentDTO.setLast_name(stud.getLastName());
		studentDTO.setEmail(stud.getEmail());
		
		return studentDTO;
	}
	
	private static Student dtoToDao(StudentDTO studentDto) {
		
		student.setId(studentDto.getId());
		student.setName(studentDto.getName());
		student.setLastName(studentDTO.getLast_name());
		student.setEmail(studentDto.getEmail());
		
		return student;
	}
}
