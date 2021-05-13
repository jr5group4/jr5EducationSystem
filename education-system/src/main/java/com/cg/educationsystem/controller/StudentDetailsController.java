package com.cg.educationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.educationsystem.entity.StudentDetails;
import com.cg.educationsystem.service.StudentDetailsService;
import com.cg.educationsystem.utils.StudentDetailsNotFoundException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student")
public class StudentDetailsController {

	@Autowired
	StudentDetailsService studentDetailsService;
	
	String string="No student details available";
	
	@PostMapping("/add")
	public ResponseEntity<List<StudentDetails>> addStudentDetails(@RequestBody StudentDetails student){
		List<StudentDetails> studentDetailsList=studentDetailsService.addStudentDetails(student);
		return new ResponseEntity<>(studentDetailsList,HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<StudentDetails>> getAllStudentDetails(){
		List<StudentDetails> studentDetailsList=studentDetailsService.getAllStudentDetails();
		if(studentDetailsList.isEmpty()) {
			throw new StudentDetailsNotFoundException(string);
		}
		return new ResponseEntity<>(studentDetailsList,HttpStatus.OK);
	}
	
	@GetMapping("/getbyid/{studentId}")
	public ResponseEntity<StudentDetails> getStudentDetailsById(@PathVariable("studentId") int studentId) {
		StudentDetails studentDetails=studentDetailsService.getStudentDetailsById(studentId);
		if(studentDetails==null) {
			throw new StudentDetailsNotFoundException(string+"id :"+studentId);
		}
		return new ResponseEntity<>(studentDetails,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<List<StudentDetails>> deleteStudent(@PathVariable("studentId") int studentId) {
		List<StudentDetails> studentDetailsList=studentDetailsService.deleteStudentDetails(studentId);
	if(studentDetailsList.isEmpty()) {
		throw new StudentDetailsNotFoundException(string);
	}
	return new ResponseEntity<>(studentDetailsList,HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<List<StudentDetails>> updateStudentDetails(@RequestBody StudentDetails student){
		List<StudentDetails> studentDetailsList=studentDetailsService.addStudentDetails(student);
		if(studentDetailsList.isEmpty()) {
			throw new StudentDetailsNotFoundException(string);
		}
		return new ResponseEntity<>(studentDetailsList,HttpStatus.OK);
	}
}

