package com.cg.educationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.educationsystem.entity.StudentDetails;
import com.cg.educationsystem.service.StudentDetailsService;
import com.cg.educationsystem.utils.StudentDetailsNotFoundException;

@RestController
@RequestMapping("/studentdetails")
public class StudentDetailsController {
	
	@Autowired
	StudentDetailsService studentDetailsService;
	
	@PostMapping("/addstudentdetails")
	public ResponseEntity<String> addStudentDetails(@RequestBody StudentDetails student){
		studentDetailsService.addStudentDetails(student);
		return new ResponseEntity<String>("Student details added",HttpStatus.OK);
	}
	
	@GetMapping("/getallstudentdetails")
	public ResponseEntity<List<StudentDetails>> getAllStudentDetails(){
		List<StudentDetails> studentDetailsList=studentDetailsService.getAllStudentDetails();
		return new ResponseEntity<List<StudentDetails>>(studentDetailsList,HttpStatus.OK);
	}
	
	@GetMapping("/getstudentdetailsbyid")
	public ResponseEntity<StudentDetails> getStudentDetailsById(@RequestBody int studentId) {
		StudentDetails studentDetails=studentDetailsService.getStudentDetailsById(studentId);
		if(studentDetails==null) {
			throw new StudentDetailsNotFoundException("No student found for student id: "+studentId);
		}
		return new ResponseEntity<StudentDetails>(studentDetails,HttpStatus.OK);
	}
}
