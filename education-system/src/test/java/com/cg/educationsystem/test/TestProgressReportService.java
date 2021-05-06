package com.cg.educationsystem.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.educationsystem.dao.ICourseRepository;
import com.cg.educationsystem.dao.IProgressReportRepository;
import com.cg.educationsystem.dto.CourseDto;
import com.cg.educationsystem.dto.ProgressReportDto;
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
	
	@Mock
	ICourseRepository courseDao;
	
	@Before
	public void init() {
		System.out.println("** before method ***");
		//MockitoAnnotations.initMocks(this); 
	}
	
	StudentDetails student=new StudentDetails(1,"Ajay","Kumar",987054321,"ajay1234@gmail.com",Date.valueOf("1995-01-01"));
	Course course=new Course(1,"Java",3,Date.valueOf("2021-01-02"),Date.valueOf("2021-04-02"),student);
	ProgressReport report=new ProgressReport(1,520,"B","Present",80,"Pass",course);
	ProgressReportDto reportDto=new ProgressReportDto(1,520,"B","Present",80.00,"Pass",1);
	
	@Test
	public void testAddReport() {
		Mockito.when(courseDao.getCourseById(reportDto.getCourseId())).thenReturn(course);
		reportService.addProgressReport(reportDto);
		Mockito.verify(reportDao,Mockito.times(1)).save(report);
		Mockito.verify(reportDao,Mockito.times(1)).findAll();
		
	}
	@Test
	public void testDeleteReport() {
		Mockito.when(reportDao.viewReportById(1)).thenReturn(report);
		reportService.deleteReport(1);
		Mockito.verify(reportDao,Mockito.times(1)).deleteById(1);
	}
	@Test
	public void testGetReportById() {
		Mockito.when(reportDao.viewReportById(1)).thenReturn(report);
		reportService.viewProgressReportById(1);
		Mockito.verify(reportDao,Mockito.times(1)).viewReportById(1);
	}
	
	@Test
	public void testCurrentReport() {
		List<ProgressReport> reportList=new ArrayList<ProgressReport>();
		reportList.add(new ProgressReport(1,520,"B","Present",80,"Pass",course));
		
		Mockito.when(reportDao.viewAllCurrentReport()).thenReturn(reportList);
		reportService.viewAllCurrentProgressReport();
		Mockito.verify(reportDao,Mockito.times(1)).viewAllCurrentReport();
	}
	
	@Test
	public void testPreviousReport() {
		List<ProgressReport> reportList=new ArrayList<ProgressReport>();
		reportList.add(new ProgressReport(1,520,"B","Present",80,"Pass",course));

		Mockito.when(reportDao.viewAllPreviousReport()).thenReturn(reportList);
		reportService.viewAllPreviousProgressReport();
		Mockito.verify(reportDao,Mockito.times(1)).viewAllPreviousReport();
	}
	
	@Test
	public void testGetAllReport() {
		List<ProgressReport> reportList=new ArrayList<ProgressReport>();
		reportList.add(new ProgressReport(1,520,"B","Present",80,"Pass",course));
		
		Mockito.when(reportDao.findAll()).thenReturn(reportList);
		reportService.viewAllProgressReport();
		Mockito.verify(reportDao,Mockito.times(1)).findAll();
	}
	
	@Test
	public void testUpdateReport() {
		Mockito.when(reportDao.viewReportById(reportDto.getProgressReportId())).thenReturn(report);
		Mockito.when(courseDao.getCourseById(reportDto.getCourseId())).thenReturn(course);
		reportService.updateReport(reportDto);
		Mockito.verify(reportDao,Mockito.times(1)).save(report);
	}
}
