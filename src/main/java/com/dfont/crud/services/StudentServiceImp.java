package com.dfont.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfont.crud.entities.Student;
import com.dfont.crud.repositories.StudentRepository;

@Service
public class StudentServiceImp implements StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	@Override
	public List<Student> getAllStudents() {
		return repository.findAll();
	}

	@Override
	public void addStudent(Student student) {
		repository.save(student);
	}

}
