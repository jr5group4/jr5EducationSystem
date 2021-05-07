package com.cg.educationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.educationsystem.dao.ICourseRepository;
import com.cg.educationsystem.dao.IPaymentRepository;
import com.cg.educationsystem.dao.IStudentDetailsRepository;
import com.cg.educationsystem.dto.PaymentDto;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.entity.Payment;


@Service
@Transactional
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
		if(course!=null) {
			Payment payment = new Payment();
			payment.setPaymentId(paymentDto.getPaymentId());
			payment.setPaymentDate(paymentDto.getPaymentDate());
			payment.setPaymentDue(paymentDto.getPaymentDue());
			payment.setFeePaid(paymentDto.getFeePaid());
			payment.setFeeStatus(paymentDto.getFeeStatus());
			
			payment.setCourse(course);
			paymentRepository.save(payment);
			return paymentRepository.findAll();
		}
		return null;
	}
	@Override
	public Payment getPaymentById(int paymentId) {
		
		return paymentRepository.getPaymentById(paymentId);
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
			paymentRepository.save(payment);
			paymentRepository.deleteById(paymentId);
			return paymentRepository.findAll();
		}
		return null;
	}
	@Override
	public List<Payment> updatePayment(PaymentDto paymentDto) {
		Payment payment=paymentRepository.getPaymentById(paymentDto.getPaymentId());
		Course course=courseRepository.getCourseById(paymentDto.getCourseId());
		if(payment!=null&&course!=null) {
			payment.setPaymentDate(paymentDto.getPaymentDate());
			payment.setPaymentDue(paymentDto.getPaymentDue());
			payment.setFeePaid(paymentDto.getFeePaid());
			payment.setFeeStatus(paymentDto.getFeeStatus());
			payment.setCourse(course);
			paymentRepository.save(payment);
			return paymentRepository.findAll();
		}
		return null;
	}


	
}
