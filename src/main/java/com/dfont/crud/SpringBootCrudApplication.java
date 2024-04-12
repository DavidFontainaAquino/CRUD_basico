package com.dfont.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dfont.crud.entities.Student;
import com.dfont.crud.services.StudentService;

@SpringBootApplication
public class SpringBootCrudApplication implements CommandLineRunner{
	
	@Autowired
	StudentService service; 
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Student student1 = new Student("Carlos", "Ramirez", "a@a.com");
		service.addStudent(student1);
		Student student2 = new Student("Marcos", "Jope", "b@a.com");
		service.addStudent(student2);
		Student student3 = new Student("Ariel", "Costa", "c@a.com");
		service.addStudent(student3);
		*/
	}

}
