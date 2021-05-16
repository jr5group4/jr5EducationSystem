package com.cg.educationsystem.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.educationsystem.dao.ICourseRepository;
import com.cg.educationsystem.dao.IPaymentRepository;
import com.cg.educationsystem.dao.IStudentDetailsRepository;
import com.cg.educationsystem.dto.PaymentDto;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.entity.Payment;
import com.cg.educationsystem.entity.StudentDetails;


@Service
public class PaymentService implements IPaymentService{
	@Autowired
	IPaymentRepository paymentRepository;
	@Autowired
	ICourseRepository courseRepository;
	@Autowired
	IStudentDetailsRepository studentRepository;
	
	@Override
	public List<Payment> addPayment(PaymentDto paymentDto) {
		Course course = courseRepository.getCourseById(paymentDto.getCourseId());
		StudentDetails student=studentRepository.getStudentDetailsById(paymentDto.getStudentId());
		if(course!=null&&student!=null) {
			Payment payment = new Payment();
			payment.setPaymentId(paymentDto.getPaymentId());
			payment.setPaymentDate(paymentDto.getPaymentDate());
			payment.setPaymentDue(paymentDto.getPaymentDue());
			payment.setFeePaid(paymentDto.getFeePaid());
			payment.setFeeStatus(paymentDto.getFeeStatus());
			
			payment.setCourse(course);
			payment.setStudent(student);
			paymentRepository.save(payment);
			return paymentRepository.findAll();
		}
		return Collections.emptyList();
	}
	@Override
	public Payment getPaymentById(int studentId) {
		
		return paymentRepository.getPaymentById(studentId);
	}
	@Override
	public List<Payment> getAllPayment() {
		return paymentRepository.findAll();
	}
	@Override
	public List<Payment> deletePayment(int paymentId) {
		Payment payment=paymentRepository.getPaymentById(paymentId);
		if(payment!=null) {
			payment.setCourse(null);
			payment.setStudent(null);
			paymentRepository.save(payment);
			paymentRepository.deleteById(paymentId);
			return paymentRepository.findAll();
		}
		return Collections.emptyList();
	}
	@Override
	public List<Payment> updatePayment(PaymentDto paymentDto) {
		Payment payment=paymentRepository.getPaymentById(paymentDto.getPaymentId());
		Course course=courseRepository.getCourseById(paymentDto.getCourseId());
		StudentDetails student=studentRepository.getStudentDetailsById(paymentDto.getStudentId());
		if(payment!=null&&course!=null&&student!=null) {
			payment.setPaymentDate(paymentDto.getPaymentDate());
			payment.setPaymentDue(paymentDto.getPaymentDue());
			payment.setFeePaid(paymentDto.getFeePaid());
			payment.setFeeStatus(paymentDto.getFeeStatus());
			payment.setCourse(course);
			payment.setStudent(student);
			paymentRepository.save(payment);
			return paymentRepository.findAll();
		}
		return Collections.emptyList();
	}


	
}
