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
	@Override
	public List<StudentDTO> getAllStudents() {
		List<StudentDTO> listStudentDTO = new ArrayList<>();
		List<Student> listStudentDao = repository.findAll();
		for (Student studentDao : listStudentDao) {
			listStudentDTO.add(daoToDto(studentDao));
		}
		return listStudentDTO;
	}

	@Override
	public void addStudent(StudentDTO studentDto) {
		repository.save(dtoToDao(studentDto));
	}
	
	private StudentDTO daoToDto(Student stud) {

		StudentDTO studentDTO=new StudentDTO();
				
		studentDTO.setId(stud.getId());
		studentDTO.setName(stud.getName());
		studentDTO.setLast_name(stud.getLastName());
		studentDTO.setEmail(stud.getEmail());
		
		return studentDTO;
	}
	
	private Student dtoToDao(StudentDTO studentDto) {

		Student studentDao=new Student();
		
		studentDao.setId(studentDto.getId());
		studentDao.setName(studentDto.getName());
		studentDao.setLastName(studentDto.getLast_name());
		studentDao.setEmail(studentDto.getEmail());
		
		return studentDao;
	}
}
