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

import com.cg.educationsystem.dto.ProgressReportDto;
import com.cg.educationsystem.entity.ProgressReport;
import com.cg.educationsystem.service.ProgressReportService;
import com.cg.educationsystem.utils.CourseNotFoundException;
import com.cg.educationsystem.utils.ProgressReportNotFoundException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/report")
public class ProgressReportController {
	@Autowired
	ProgressReportService reportService;
	
	String string="No Progress Report Available ";
	
	@PostMapping("/add")
	public ResponseEntity<List<ProgressReport>> addProgressReport(@RequestBody ProgressReportDto reportDto){
		List<ProgressReport> report= reportService.addProgressReport(reportDto);
		if(report.isEmpty()) {
			throw new CourseNotFoundException("Course not available for Id: "+reportDto.getCourseId());
		}
		return new ResponseEntity<>(report,HttpStatus.OK);
	}
	@GetMapping("/getall")
	public ResponseEntity<List<ProgressReport>> viewAllReport(){
		List<ProgressReport> reportList=reportService.viewAllProgressReport();
		if(reportList.isEmpty()) {
			throw new ProgressReportNotFoundException(string);
		}
		return new ResponseEntity<>(reportList,HttpStatus.OK);
	}
	
	@GetMapping("/getprevious/{studentId}")
	public ResponseEntity<List<ProgressReport>> viewPreviousReport(@PathVariable int studentId){
		List<ProgressReport> reportList=reportService.viewAllPreviousProgressReport(studentId);
		if(reportList.isEmpty()) {
			throw new ProgressReportNotFoundException(string);
		}
		return new ResponseEntity<>(reportList,HttpStatus.OK);
	}
	@GetMapping("/getcurrent/{studentId}")
	public ResponseEntity<List<ProgressReport>> viewCurrentReport(@PathVariable int studentId){
		List<ProgressReport> reportList=reportService.viewAllCurrentProgressReport(studentId);
		if(reportList.isEmpty()) {
			throw new ProgressReportNotFoundException(string);
		}
		return new ResponseEntity<>(reportList,HttpStatus.OK);
	}
	
	@GetMapping("/getbyid/{reportId}")
	public ResponseEntity<ProgressReport> viewReportById(@PathVariable int reportId){
		ProgressReport report=reportService.viewProgressReportById(reportId);
		if(report==null) {
			throw new ProgressReportNotFoundException(string+"id :"+reportId);
		}
		return new ResponseEntity<>(report,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{progressReportId}")
	public ResponseEntity<List<ProgressReport>> deleteReport(@PathVariable("progressReportId") int progressReportId){
		List<ProgressReport> report=reportService.deleteReport(progressReportId);
		if(report.isEmpty()) {
			throw new ProgressReportNotFoundException(string+"id :"+progressReportId);
		}
		return new ResponseEntity<>(report,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<List<ProgressReport>> updateReport(@RequestBody ProgressReportDto reportDto){
		List<ProgressReport> report=reportService.updateReport(reportDto);
		if(report.isEmpty()) {
			throw new ProgressReportNotFoundException(string+"id :"+reportDto.getProgressReportId());
		}
		return new ResponseEntity<>(report,HttpStatus.OK);
	}
	
}
