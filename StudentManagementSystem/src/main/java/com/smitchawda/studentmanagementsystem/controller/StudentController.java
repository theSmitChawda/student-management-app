package com.smitchawda.studentmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smitchawda.studentmanagementsystem.dao.StudentDao;
import com.smitchawda.studentmanagementsystem.model.Student;

@Controller
public class StudentController {
	@Autowired
	StudentDao repo;
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students",repo.findAll());
		return "students";	
	}
	
	@GetMapping("/students/new")
	public String addStudent(Model m){
		Student s = new Student();
		m.addAttribute("student",s);
		return "addStudent";
	}
	
	@PostMapping("/students") 
	public String saveStudent(@ModelAttribute("student") Student student) {
		repo.save(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/update")
	public String updateStudent(Model m) {
		
		return "updateStudent";
	}
}
