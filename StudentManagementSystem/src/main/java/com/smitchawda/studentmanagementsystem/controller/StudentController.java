package com.smitchawda.studentmanagementsystem.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@GetMapping("/students/update/{id}")
	public String updateStudent(@PathVariable("id") Long id, Model m) {
		m.addAttribute("student",repo.findById(id).get());
		return "updateStudent";
	}
	
	@PostMapping("/students/{id}")
	public String update(@PathVariable("id") Long id, @ModelAttribute("student") Student student, Model m) {
		Optional<Student> exStudent = repo.findById(id);
		exStudent.get().setId(student.getId());
		exStudent.get().setFirstName(student.getFirstName());
		exStudent.get().setLastName(student.getLastName());
		exStudent.get().setEmail(student.getEmail());
		
		repo.save(exStudent.get());
		return "redirect:/students";
	}
	
	@GetMapping("/students/delete/{id}")
	public String removeStudent(@PathVariable("id") Long id ,Model m){
		m.addAttribute("student",repo.findById(id).get());
		return "deleteStudent";
	}
	
	@PostMapping("/students/confirm-delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		repo.deleteById(id);
		return "redirect:/students";
	}
}