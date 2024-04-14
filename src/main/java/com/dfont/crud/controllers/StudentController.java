package com.dfont.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dfont.crud.dto.StudentDTO;
import com.dfont.crud.services.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students_list", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String newStudentForm(Model model) {
		StudentDTO studentDto = new StudentDTO();
		model.addAttribute("studentDto", studentDto);
		return "new_student_form";
	}
	@PostMapping("/students/new")
	public String addNewStudent(@ModelAttribute("studentDto") StudentDTO studentDto) {
		studentService.saveStudent(studentDto);
		return "redirect:/students/new";
		
	}
}
