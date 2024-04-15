package com.dfont.crud.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		Optional<StudentDTO> optStudentDto = studentService.getStudentById(id);
		if(optStudentDto.isPresent()) {
			model.addAttribute("studentDto", optStudentDto.get());
			return "edit_student_form";
		} else {
			return newStudentForm(model);
		}
	}
	@PostMapping("/students/edit/{id}")
	public String editStudent(@ModelAttribute("studentDto") StudentDTO studentDto, @PathVariable Long id) {
		Optional<StudentDTO> optStudentDto= studentService.getStudentById(id);
		if(optStudentDto.isPresent()) {
			StudentDTO localStudentDto = optStudentDto.get();
			localStudentDto.setId(id);
			localStudentDto.setName(studentDto.getName());
			localStudentDto.setLast_name(studentDto.getLast_name());
			localStudentDto.setEmail(studentDto.getEmail());
			
		}
		studentService.saveStudent(studentDto);
		return "redirect:/students";
	}
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id, Model model) {
		studentService.deleteStudent(id);
		model.addAttribute("students_list", studentService.getAllStudents());
		return "students";
	}
	
}
