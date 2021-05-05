package com.cg.educationsystem.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.cg.educationsystem.dto.ProgressReportDto;
import com.cg.educationsystem.entity.ProgressReport;
import com.cg.educationsystem.service.ProgressReportService;
import com.cg.educationsystem.utils.CourseNotFoundException;
import com.cg.educationsystem.utils.ProgressReportNotFoundException;

@RestController
@RequestMapping("/report")
public class ProgressReportController {
	@Autowired
	ProgressReportService reportService;
	
	@PostMapping("/add")
	public ResponseEntity<List<ProgressReport>> addProgressReport(@RequestBody ProgressReportDto reportDto){
		List<ProgressReport> report= reportService.addProgressReport(reportDto);
		if(report==null) {
			throw new CourseNotFoundException("Course not available for Id: "+reportDto.getCourseId());
		}
		return new ResponseEntity<>(report,HttpStatus.OK);
	}
	
	@GetMapping("/getprevious")
	public ResponseEntity<List<ProgressReport>> viewPreviousReport(){
		List<ProgressReport> reportList=reportService.viewAllPreviousProgressReport();
		if(reportList.isEmpty()) {
			throw new ProgressReportNotFoundException("No Progress Report Available ");
		}
		return new ResponseEntity<>(reportList,HttpStatus.OK);
	}
	@GetMapping("/getcurrent")
	public ResponseEntity<List<ProgressReport>> viewCurrentReport(){
		List<ProgressReport> reportList=reportService.viewAllCurrentProgressReport();
		if(reportList.isEmpty()) {
			throw new ProgressReportNotFoundException("No Progress Report Available ");
		}
		return new ResponseEntity<>(reportList,HttpStatus.OK);
	}
	
	@GetMapping("/getbyid/{reportId}")
	public ResponseEntity<ProgressReport> viewReportById(@PathVariable int reportId){
		ProgressReport report=reportService.viewProgressReportById(reportId);
		if(report==null) {
			throw new ProgressReportNotFoundException("No Progress Report Found for Report Id : "+reportId);
		}
		return new ResponseEntity<>(report,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{reportId}")
	public ResponseEntity<List<ProgressReport>> deleteReport(@PathVariable int reportId){
		List<ProgressReport> report=reportService.deleteReport(reportId);
		if(report==null) {
			throw new ProgressReportNotFoundException("No Progress Report Found for Report Id : "+reportId);
		}
		return new ResponseEntity<>(report,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<List<ProgressReport>> updateReport(@RequestBody ProgressReportDto reportDto){
		List<ProgressReport> report=reportService.updateReport(reportDto);
		if(report==null) {
			throw new ProgressReportNotFoundException("No Progress Report Found for Report Id : "+reportDto.getProgressReportId());
		}
		return new ResponseEntity<>(report,HttpStatus.OK);
	}
	
}
