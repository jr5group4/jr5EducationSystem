package com.cg.educationsystem.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.educationsystem.entity.StudentDetails;
import com.cg.educationsystem.service.StudentDetailsService;
import com.cg.educationsystem.utils.StudentDetailsNotFoundException;

@RestController
@RequestMapping("/studentdetails")
public class StudentDetailsController {
	
	@Autowired
	StudentDetailsService studentDetailsService;
	
	@PostMapping("/add")
	public ResponseEntity<List<StudentDetails>> addStudentDetails(@RequestBody StudentDetails student){
		List<StudentDetails> studentDetailsList=studentDetailsService.addStudentDetails(student);
		return new ResponseEntity<>(studentDetailsList,HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<StudentDetails>> getAllStudentDetails(){
		List<StudentDetails> studentDetailsList=studentDetailsService.getAllStudentDetails();
		if(studentDetailsList.isEmpty()) {
			throw new StudentDetailsNotFoundException("No student details available");
		}
		return new ResponseEntity<>(studentDetailsList,HttpStatus.OK);
	}
	
	@GetMapping("/getbyid/{studentId}")
	public ResponseEntity<StudentDetails> getStudentDetailsById(@PathVariable int studentId) {
		StudentDetails studentDetails=studentDetailsService.getStudentDetailsById(studentId);
		if(studentDetails==null) {
			throw new StudentDetailsNotFoundException("No student found for student id: "+studentId);
		}
		return new ResponseEntity<>(studentDetails,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<List<StudentDetails>> deleteStudent(@PathVariable int studentId) {
		List<StudentDetails> studentDetailsList=studentDetailsService.deleteStudentDetails(studentId);
	if(studentDetailsList==null) {
		throw new StudentDetailsNotFoundException("No student details available");
	}
	return new ResponseEntity<>(studentDetailsList,HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<List<StudentDetails>> updateStudentDetails(@RequestBody StudentDetails student){
		List<StudentDetails> studentDetailsList=studentDetailsService.addStudentDetails(student);
		if(studentDetailsList==null) {
			throw new StudentDetailsNotFoundException("No student details available");
		}
		return new ResponseEntity<>(studentDetailsList,HttpStatus.OK);
	}
}

