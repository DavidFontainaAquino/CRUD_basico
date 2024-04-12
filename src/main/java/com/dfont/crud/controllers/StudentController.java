package com.dfont.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
