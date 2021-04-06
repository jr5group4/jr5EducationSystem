package com.cg.educationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.educationsystem.dao.IStudentDetailsRepository;
import com.cg.educationsystem.entity.StudentDetails;

@Service
public class StudentDetailsService implements IStudentDetailsService {
	@Autowired
	IStudentDetailsRepository dao;

	@Override
	public void addStudentDetails(StudentDetails student) {
		 dao.save(student);
	}

	@Override
	public List<StudentDetails> getAllStudentDetails() {
		return dao.findAll();
	}

	@Override
	public StudentDetails getStudentDetailsById(int studentId) {
		return dao.getStudentDetailsById(studentId);
	}
}
	
