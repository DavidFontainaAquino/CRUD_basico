package com.dfont.crud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public StudentDTO saveStudent(StudentDTO studentDto) {
		return daoToDto(repository.save(dtoToDao(studentDto)));
	}
	
	@Override
	public Optional<StudentDTO> getStudentById(Long id) {
		Optional<Student> optStudent = repository.findById(id);
		if(optStudent.isPresent()) {
			return Optional.of(daoToDto(optStudent.get()));
		}
		return Optional.empty();
	}
	
	@Override
	public StudentDTO updateStudent(StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudent(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Boolean studentExistById(Long id) {
		return repository.existsById(id);
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
