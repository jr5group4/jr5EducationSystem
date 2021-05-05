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
import com.cg.educationsystem.dao.IStudentDetailsRepository;
import com.cg.educationsystem.dto.CourseDto;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.entity.Payment;
import com.cg.educationsystem.entity.StudentDetails;
import com.cg.educationsystem.service.CourseService;
import com.cg.educationsystem.service.StudentDetailsService;

@RunWith(MockitoJUnitRunner.class)
public class TestCourseService {
	
	@InjectMocks
	CourseService courseService;
	
	@InjectMocks
	StudentDetailsService studentDetailsService;
	
	@Mock
	ICourseRepository courseDao;
	
	@Mock
	IStudentDetailsRepository studentDao;
	
	@Before
	public void init() {
		System.out.println("***before method***");
		//MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testAddCourse() {
		/*Course course=new Course(1,"Java",5,Date.valueOf("2020-10-10"),Date.valueOf("2021-03-10"));
		
		courseService.addCourseDetails(course);
		Mockito.verify(courseDao,Mockito.times(1)).save(course);*/
	}
	
	@Test
	public void testRegisterCourse() {

		/*StudentDetails student=new StudentDetails(1,"Ajay","Kumar",987054321,"ajay1234@gmail.com",Date.valueOf("1995-01-01"));
		CourseDto courseDto= new CourseDto(1,"Java",5,Date.valueOf("2020-10-10"),Date.valueOf("2021-03-10"),1);
		Course course=new Course(1,"Java",5,Date.valueOf("2020-10-10"),Date.valueOf("2021-03-10"),student);
		
		Mockito.when(courseDao.getCourseById(courseDto.getCourseId())).thenReturn(course);
		Mockito.when(studentDao.getStudentDetailsById(courseDto.getStudentId())).thenReturn(student);
		
		courseService.registerCourse(courseDto);
		Mockito.verify(courseDao,Mockito.times(1)).save(course);*/
	}
	
	@Test
	public void testGetAllCourse() {
		List<Course> courseList=new ArrayList<>();
		StudentDetails student=new StudentDetails(1,"Ajay","Kumar",987054321,"ajay1234@gmail.com",Date.valueOf("1995-01-01"));
		courseList.add(new Course(1,"Java",5,Date.valueOf("2020-10-10"),Date.valueOf("2021-03-10"),student));
		
		Mockito.when(courseDao.findAll()).thenReturn(courseList);
	    List<Course> list=courseService.getAllCourse();
		Assertions.assertEquals(1,list.size());
		Mockito.verify(courseDao,Mockito.times(1)).findAll();
	} 
	
	@Test
	public void testGetCourseById() {
		StudentDetails student=new StudentDetails(1,"Ajay","Kumar",987054321,"ajay1234@gmail.com",Date.valueOf("1995-01-01"));
		Course course=new Course(1,"Java",5,Date.valueOf("2020-10-10"),Date.valueOf("2021-03-10"),student);
		
		Mockito.when(courseDao.getCourseById(1)).thenReturn(course);
		Course newCourse=courseService.getCourseById(1);
		Assertions.assertEquals(course,newCourse);
		Mockito.verify(courseDao,Mockito.times(1)).getCourseById(1);
	}
}
