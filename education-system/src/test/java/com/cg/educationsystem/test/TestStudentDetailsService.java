package com.cg.educationsystem.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
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
	
	@Test
	public void testGetAllStudents() {
		List<StudentDetails> studentList=new ArrayList<StudentDetails>();
		studentList.add(new StudentDetails(1,"Ram","Kumar",123456789,"ram123@gmail.com",Date.valueOf("1994-01-22")));
		Mockito.when(studentDao.findAll()).thenReturn(studentList);
		List<StudentDetails> newStudentList=studentService.getAllStudentDetails();
		Mockito.verify(studentDao,Mockito.times(1)).findAll();
	}
	
	@Test
	public void testGetStudentById() {
		StudentDetails student=new StudentDetails(1,"Ram","Kumar",123456789,"ram123@gmail.com",Date.valueOf("1994-01-22"));
		Mockito.when(studentDao.getStudentDetailsById(1)).thenReturn(student);
		StudentDetails newStudent=studentService.getStudentDetailsById(1);
		Mockito.verify(studentDao,Mockito.times(1)).getStudentDetailsById(1);
	}
	
	@Test
	public void testAddStudent() {
		StudentDetails student=new StudentDetails(1,"Ram","Kumar",123456789,"ram123@gmail.com",Date.valueOf("1994-01-22"));
		studentService.addStudentDetails(student);
		Assert.assertNotNull(student.getStudentId());
		Mockito.verify(studentDao,Mockito.times(1)).save(student);
	}
}
