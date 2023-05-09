  package com.example.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.school.model.Stud;
import com.example.school.repository.StudentRepository;


@Service
public class StudentServicesImpl implements StudentServices {
	
	
	@Autowired
	StudentRepository studentrepo;

	@Override
	public Stud addStudent(Stud student) {
	return studentrepo.save(student);
	}

	@Override
	public Optional<Stud> searchStudent(int rollNo) {
		return studentrepo.findById(rollNo);
	}

	@Override
	public void deleteStudent(int rollNo) {
		studentrepo.deleteById(rollNo);
	}

	@Override
	public List<Stud> showAllRecord() {
		List<Stud> student = (List<Stud>) studentrepo.findAll();
		return student;
	}

	

	

	
	

	
	
	

}
