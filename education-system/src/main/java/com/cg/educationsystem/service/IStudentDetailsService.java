package com.cg.educationsystem.service;

import java.util.List;

import com.cg.educationsystem.entity.StudentDetails;


public interface IStudentDetailsService {
	//allows admin to add student details
	public void addStudentDetails(StudentDetails student);
	//allows admin to view all student details
	public List<StudentDetails> getAllStudentDetails();
	//allows admin to view individual student details 
	public StudentDetails getStudentDetailsById(int studentId);
	
	public List<StudentDetails> deleteStudentDetails(int studentId);
	
	public List<StudentDetails> updateStudentDetails(StudentDetails studentDetails);
	
	
}
