package com.cg.educationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.educationsystem.dao.IStudentDetailsRepository;
import com.cg.educationsystem.entity.StudentDetails;

@Service
public class StudentDetailsService {
	@Autowired
	IStudentDetailsRepository dao;
	
	public void addStudentDetails(StudentDetails student) {
		dao.save(student);
	}
	public List<StudentDetails> getAllStudentDetails(){
		List<StudentDetails> studentList=dao.findAll();
		return studentList;
	}
	
	public StudentDetails getStudentDetailsById(int studentId) {
		return dao.getStudentDetailsById(studentId);
	}

}
