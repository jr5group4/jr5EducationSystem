package com.cg.educationsystem.service;

import java.util.List;

import com.cg.educationsystem.entity.StudentDetails;



public interface IStudentDetailsService {
	public  String addStudentDetails(StudentDetails student);
	public List<StudentDetails> getAllStudentDetails();
	public StudentDetails getStudentDetailsById(int studentId);
	
}
