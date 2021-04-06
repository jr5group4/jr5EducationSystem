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
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.educationsystem.dao.ICourseRepository;
import com.cg.educationsystem.dao.IPaymentRepository;
import com.cg.educationsystem.dao.IStudentDetailsRepository;
import com.cg.educationsystem.dto.PaymentDto;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.entity.Payment;
import com.cg.educationsystem.entity.StudentDetails;
import com.cg.educationsystem.service.CourseService;
import com.cg.educationsystem.service.PaymentService;


@RunWith(MockitoJUnitRunner.class)
public class TestPaymentService {
	@InjectMocks
	PaymentService paymentService;
	
	@InjectMocks
	CourseService courseService;
	
	@Mock
	IPaymentRepository paymentDao; 
	
	@Mock
	ICourseRepository courseDao;
	
	@Mock
	IStudentDetailsRepository studentDao;
	
	@Before
	public void init() {
		System.out.println("** before method ***");
		//MockitoAnnotations.initMocks(this); 
	}
	
	@Test
	public void testAddPayment() {
		//StudentDetails student=new StudentDetails(1,"Ajay","Kumar",987054321,"ajay1234@gmail.com",Date.valueOf("1995-01-01"));
		//Course course=new Course(1,"Java",3,Date.valueOf("2021-01-02"),Date.valueOf("2021-04-02"),student);
		PaymentDto paymentdto=new PaymentDto(1,Date.valueOf("2021-01-01"),Date.valueOf("2021-01-15"),1500.0,"Paid",1);
		
		StudentDetails student=new StudentDetails(1,"Ajay","Kumar",987054321,"ajay1234@gmail.com",Date.valueOf("1995-01-01"));
		Course course=new Course(1,"Java",3,Date.valueOf("2021-01-02"),Date.valueOf("2021-04-02"),student);
	    Payment payment=new Payment(1,Date.valueOf("2021-01-01"),Date.valueOf("2021-01-15"),1500.0,"Paid",course);
		
	    //courseService.addCourseDetails(course);
		paymentService.addPayment(paymentdto);
		//Mockito.when(courseDao.findById(course.getCourseId()).get()).thenReturn(course);
		//studentDao.save(student);
		//courseDao.save(course);
		//Assert.assertNotNull(paymentdto.getPaymentId());
		//Mockito.verify(studentDao,Mockito.times(1)).save(student);
		
		//Mockito.verify(courseDao,Mockito.times(1)).findById(1).get();
		Mockito.verify(paymentDao,Mockito.times(1)).save(payment);
	}
	
	@Test
	public void testGetAllPayment() {
		List<Payment> paymentList=new ArrayList<>();
		StudentDetails student=new StudentDetails(1,"Ajay","Kumar",987054321,"ajay1234@gmail.com",Date.valueOf("1995-01-01"));
		Course course=new Course(1,"Java",3,Date.valueOf("2021-01-02"),Date.valueOf("2021-04-02"),student);
		paymentList.add(new Payment(1,Date.valueOf("2021-01-01"),Date.valueOf("2021-01-15"),1500,"Paid",course));
		
		Mockito.when(paymentDao.findAll()).thenReturn(paymentList);
	    List<Payment> list=paymentService.getAllPayment();
		Assertions.assertEquals(1,list.size());
		Mockito.verify(paymentDao,Mockito.times(1)).findAll();
	}
	
	@Test
	public void testGetPaymentById() {
		StudentDetails student=new StudentDetails(1,"Ajay","Kumar",987054321,"ajay1234@gmail.com",Date.valueOf("1995-01-01"));
		Course course=new Course(1,"Java",3,Date.valueOf("2021-01-02"),Date.valueOf("2021-04-02"),student);
	    Payment payment=new Payment(1,Date.valueOf("2021-01-01"),Date.valueOf("2021-01-15"),1500.0,"Paid",course);
	    
		Mockito.when(paymentDao.getPaymentById(1)).thenReturn(payment);
		Payment newPayment=paymentService.getPaymentById(1);
		Mockito.verify(paymentDao,Mockito.times(1)).getPaymentById(1);
	}
}
