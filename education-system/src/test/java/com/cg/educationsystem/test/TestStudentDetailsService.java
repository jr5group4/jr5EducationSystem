package com.cg.educationsystem.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.educationsystem.dao.IStudentDetailsRepository;
import com.cg.educationsystem.entity.StudentDetails;
import com.cg.educationsystem.service.StudentDetailsService;

@RunWith(MockitoJUnitRunner.class)
public class TestStudentDetailsService {
	@InjectMocks
	StudentDetailsService studentService;
	
	@Mock
	IStudentDetailsRepository studentDao;
	
	@Before
	public void init() {
		System.out.println("** before method ***");
		//MockitoAnnotations.initMocks(this); 
	}
	
	@Test
	public void testAddStudent() {
		StudentDetails student=new StudentDetails(1,"Ajay","Kumar",9870543212l,"ajay1234@gmail.com",Date.valueOf("1995-01-01"));
		studentService.addStudentDetails(student);
		Assert.assertNotNull(student.getStudentId());
		Mockito.verify(studentDao,Mockito.times(1)).save(student);
	}
	
	@Test
	public void testGetAllStudent() {
		List<StudentDetails> student=new ArrayList<StudentDetails>();
		student.add(new StudentDetails(1,"Ajay","Kumar",9870543214l,"ajay1234@gmail.com",Date.valueOf("1995-01-01")));
		Mockito.when(studentDao.findAll()).thenReturn(student);
		List<StudentDetails> newStudent=studentService.getAllStudentDetails();
		Assertions.assertEquals(1,newStudent.size());
		Mockito.verify(studentDao,Mockito.times(1)).findAll();
	}
	@Test
	public void testGetStudentById() {
		StudentDetails student=new StudentDetails(1,"Ajay","Kumar",9870543215l,"ajay1234@gmail.com",Date.valueOf("1995-01-01"));
		Mockito.when(studentDao.getStudentDetailsById(1)).thenReturn(student);
		studentService.getStudentDetailsById(1);
		Mockito.verify(studentDao,Mockito.times(1)).getStudentDetailsById(1);
	}
}
