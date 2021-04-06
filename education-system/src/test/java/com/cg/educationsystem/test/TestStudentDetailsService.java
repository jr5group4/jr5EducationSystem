package com.cg.educationsystem.test;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.educationsystem.dao.IStudentDetailsRepository;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.entity.StudentDetails;
import com.cg.educationsystem.service.StudentDetailsService;


@RunWith(MockitoJUnitRunner.class)
public class TestStudentDetailsService {
	@InjectMocks
	StudentDetailsService studentDetailsService;
	
	@Mock
	IStudentDetailsRepository studentDetailsDao;
	@Before
	public void init() {
		System.out.println("** before method **");
		//MockitoAnnotations.initMocks(this);
	}
	
	/*@Test
	public void testAddStudentDetails() {
		StudentDetails studentDetails = new StudentDetails();
		studentDetails.setStudentId(1);
		studentDetails.setFirstName("Raj");
		studentDetails.setLastName("Patil");
		studentDetails.setDateOfBirth(Date.valueOf("2000-09-03"));
		studentDetails.setPhoneNumber(987654326l);
		studentDetails.setStudentEmailId("raj03@gmail.com");
		studentDetailsService.addStudentDetails(studentDetails);
		//dao.save(studentDetails);
		Assert.assertNotNull(studentDetails.getStudentId());
		Mockito.verify(studentDetailsDao, Mockito.times(1)).save(studentDetails);
	}*/
	@Test
	public void testGetAllStudentDetails() {
		List<StudentDetails> courseList=new ArrayList<>();
		courseList.add(new StudentDetails(1,"Ajay","Kumar",9870543214l,"ajay1234@gmail.com",Date.valueOf("1995-01-01")));
		//courseList.add(new Course(1,"Java",5,Date.valueOf("2020-10-10"),Date.valueOf("2021-03-10"),student));
		
		Mockito.when(studentDetailsDao.findAll()).thenReturn(courseList);
	    List<StudentDetails> list=studentDetailsService.getAllStudentDetails();
		Assertions.assertEquals(1,list.size());
		Mockito.verify(studentDetailsDao,Mockito.times(1)).findAll();
		
		
	/*	List<StudentDetails> studentDetailsList = new ArrayList<StudentDetails>();
		studentDetailsList.add(new StudentDetails(1, "Raj", "Patil", 9875489624l, "raj02@gmail.com", Date.valueOf("2000-09-20")));
		studentDetailsList.add(new StudentDetails(2, "Gopal", "Singh", 9856172534l, "gopalsingh@gmail.com", Date.valueOf("2001-03-30")));
		
		Mockito.when(studentDetailsDao.findAll()).thenReturn(studentDetailsList);
		List<StudentDetails> list = studentDetailsService.getAllStudentDetails();
		Assertions.assertEquals(2, list.size());
		Mockito.verify(studentDetailsDao, Mockito.times(1)).findAll();*/
	}
/*	@Test
	public void testGetStudentDetailsById() {
		StudentDetails student=new StudentDetails(1,"Ajay","Kumar",9870543213l,"ajay1234@gmail.com",Date.valueOf("1995-01-01"));

		Mockito.when(studentDetailsDao.getStudentDetailsById(1)).thenReturn(student);
		StudentDetails newStudent=studentDetailsService.getStudentDetailsById(1);
		Mockito.verify(studentDetailsDao,Mockito.times(1)).getStudentDetailsById(1);
	}*/
	
}
