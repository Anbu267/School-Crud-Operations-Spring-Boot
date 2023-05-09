package com.example.school.service;

import java.util.List;
import java.util.Optional;



import com.example.school.model.Stud;


public interface StudentServices {
	
	Stud addStudent(Stud student);
	
	Optional<Stud>searchStudent(int rollNo);
	void deleteStudent(int rollNo);
	
	List<Stud>showAllRecord();

}
