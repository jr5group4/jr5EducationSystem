package com.cg.educationsystem.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.educationsystem.dao.IProgressReportRepository;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.entity.ProgressReport;
import com.cg.educationsystem.entity.StudentDetails;
import com.cg.educationsystem.service.ProgressReportService;

@RunWith(MockitoJUnitRunner.class)
public class TestProgressReportService {
	@InjectMocks
	ProgressReportService reportService;
	
	@Mock
	IProgressReportRepository reportDao;
	
	@Before
	public void init() {
		System.out.println("** before method ***");
		//MockitoAnnotations.initMocks(this); 
	}
	
	@Test
	public void testGetReportById() {
		StudentDetails student=new StudentDetails(1,"Ajay","Kumar",987054321,"ajay1234@gmail.com",Date.valueOf("1995-01-01"));
		Course course=new Course(1,"Java",3,Date.valueOf("2021-01-02"),Date.valueOf("2021-04-02"),student);
		ProgressReport report=new ProgressReport(1,520,"B","Present",80,"Pass",course);
		
		Mockito.when(reportDao.viewReportById(1)).thenReturn(report);
		ProgressReport newReport=reportService.viewProgressReportById(1);
		Mockito.verify(reportDao,Mockito.times(1)).viewReportById(1);
	}
	
	@Test
	public void testCurrentReport() {
		StudentDetails student=new StudentDetails(1,"Ajay","Kumar",987054321,"ajay1234@gmail.com",Date.valueOf("1995-01-01"));
		Course course=new Course(1,"Java",3,Date.valueOf("2021-03-02"),Date.valueOf("2021-06-02"),student);
		List<ProgressReport> reportList=new ArrayList<ProgressReport>();
		reportList.add(new ProgressReport(1,520,"B","Present",80,"Pass",course));
		
		Mockito.when(reportDao.viewAllCurrentReport()).thenReturn(reportList);
		List<ProgressReport> newReportList=reportService.viewAllCurrentProgressReport();
		Mockito.verify(reportDao,Mockito.times(1)).viewAllCurrentReport();
	}
	
	@Test
	public void testPreviousReport() {
		StudentDetails student=new StudentDetails(1,"Ajay","Kumar",987054321,"ajay1234@gmail.com",Date.valueOf("1995-01-01"));
		Course course=new Course(1,"Java",3,Date.valueOf("2021-01-02"),Date.valueOf("2021-04-02"),student);
		List<ProgressReport> reportList=new ArrayList<ProgressReport>();
		reportList.add(new ProgressReport(1,520,"B","Present",80,"Pass",course));
		
		Mockito.when(reportDao.viewAllPreviousReport()).thenReturn(reportList);
		List<ProgressReport> newReportList=reportService.viewAllPreviousProgressReport();
		Mockito.verify(reportDao,Mockito.times(1)).viewAllPreviousReport();
	}
}
