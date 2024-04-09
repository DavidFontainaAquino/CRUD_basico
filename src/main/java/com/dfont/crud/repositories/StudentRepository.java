package com.dfont.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dfont.crud.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
}
