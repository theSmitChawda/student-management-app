package com.smitchawda.studentmanagementsystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.smitchawda.studentmanagementsystem.dao.StudentDao;
import com.smitchawda.studentmanagementsystem.model.Student;


@SpringBootApplication
public class StudentManagementSystemApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	
	
}
