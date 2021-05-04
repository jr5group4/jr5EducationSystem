package com.cg.educationsystem.service;

import java.util.List;
import java.util.Optional;

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
	public void addPayment(PaymentDto paymentDto) {
		//Optional<Course> courseOptional=courseRepository.findById(paymentDto.getCourseId());
			Payment payment = new Payment();
			payment.setPaymentId(paymentDto.getPaymentId());
			payment.setPaymentDate(paymentDto.getPaymentDate());
			payment.setPaymentDue(paymentDto.getPaymentDue());
			payment.setFeePaid(paymentDto.getFeePaid());
			payment.setFeeStatus(paymentDto.getFeeStatus());
			
			Course course = courseRepository.getCourseById(paymentDto.getCourseId());
			payment.setCourse(course);
			paymentRepository.save(payment);
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
	public int deletePayment(int paymentId) {
		Payment payment=paymentRepository.getPaymentById(paymentId);
		if(payment!=null) {
			paymentRepository.deleteById(paymentId);
			return 1;
		}
		return 0;
	}
	@Override
	public int updatePayment(PaymentDto paymentDto) {
		Payment payment=paymentRepository.getPaymentById(paymentDto.getPaymentId());
		Course course=courseRepository.getCourseById(paymentDto.getCourseId());
		if(payment!=null&&course!=null) {
			payment.setPaymentDate(paymentDto.getPaymentDate());
			payment.setPaymentDue(paymentDto.getPaymentDue());
			payment.setFeePaid(paymentDto.getFeePaid());
			payment.setFeeStatus(paymentDto.getFeeStatus());
			payment.setCourse(course);
			return 1;
		}
		return 0;
	}


	
}
