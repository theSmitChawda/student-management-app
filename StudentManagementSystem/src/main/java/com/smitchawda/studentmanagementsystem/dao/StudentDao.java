package com.smitchawda.studentmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smitchawda.studentmanagementsystem.model.Student;

public interface StudentDao extends JpaRepository<Student, Long>{
	
}
