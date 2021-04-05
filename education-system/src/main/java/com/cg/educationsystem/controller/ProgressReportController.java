package com.cg.educationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.educationsystem.dto.ProgressReportDto;
import com.cg.educationsystem.entity.ProgressReport;
import com.cg.educationsystem.service.ProgressReportService;
import com.cg.educationsystem.utils.ProgressReportNotFoundException;

@RestController
@RequestMapping("/report")
public class ProgressReportController {
	@Autowired
	ProgressReportService reportService;
	
	@PostMapping("/addreport")
	public ResponseEntity<String> addProgressReport(@RequestBody ProgressReportDto reportDto){
		String string=reportService.addProgressReport(reportDto);
		return new ResponseEntity<String>("Progress Report Added",HttpStatus.OK);
	}
	
	@GetMapping("/previousreport")
	public ResponseEntity<List<ProgressReport>> viewPreviousReport(){
		List<ProgressReport> reportList=reportService.viewAllPreviousProgressReport();
		if(reportList.isEmpty()) {
			throw new ProgressReportNotFoundException("No Progress Report Available ");
		}
		return new ResponseEntity<List<ProgressReport>>(reportList,HttpStatus.OK);
	}
	@GetMapping("/currentreport")
	public ResponseEntity<List<ProgressReport>> viewCurrentReport(){
		List<ProgressReport> reportList=reportService.viewAllCurrentProgressReport();
		if(reportList.isEmpty()) {
			throw new ProgressReportNotFoundException("No Progress Report Available ");
		}
		return new ResponseEntity<List<ProgressReport>>(reportList,HttpStatus.OK);
	}
	
	@GetMapping("/getreport/{reportId}")
	public ResponseEntity<ProgressReport> viewReportById(@PathVariable int reportId){
		ProgressReport report=reportService.viewProgressReportById(reportId);
		if(report==null) {
			throw new ProgressReportNotFoundException("No Progress Report Found for Report Id : "+reportId);
		}
		return new ResponseEntity<ProgressReport>(report,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletereport/{reportId}")
	public ResponseEntity<String> deleteReport(@PathVariable int reportId){
		int number=reportService.deleteReport(reportId);
		if(number==0) {
			throw new ProgressReportNotFoundException("No Progress Report Found for Report Id : "+reportId);
		}
		return new ResponseEntity<String>("Progress Report Deleted",HttpStatus.OK);
	}
}