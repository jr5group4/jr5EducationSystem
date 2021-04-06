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
	public void addPayment(PaymentDto paymentDto) {
		Payment payment = new Payment();
		payment.setPaymentId(paymentDto.getPaymentId());
		payment.setPaymentDate(paymentDto.getPaymentDate());
		payment.setPaymentDue(paymentDto.getPaymentDue());
		payment.setFeePaid(paymentDto.getFeePaid());
		payment.setFeeStatus(paymentDto.getFeeStatus());
		
		/*StudentDetails studentDetails = studentRepository.findById(paymentDto.getStudentId()).get();
		payment.setStudentDetails(studentDetails);
		paymentRepository.save(payment);*/
		Course course = courseRepository.findById(paymentDto.getCourseId()).get();
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


	
}
