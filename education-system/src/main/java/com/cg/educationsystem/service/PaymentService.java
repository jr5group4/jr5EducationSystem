package com.cg.educationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.educationsystem.dao.IPaymentRepository;
import com.cg.educationsystem.entity.Payment;

@Service
public class PaymentService {
	@Autowired
	IPaymentRepository dao;
	public void addPayment(Payment payment) {
		dao.save(payment);
	}
	public Payment getPaymentById(int studentId) {
		return dao.getPaymentById(studentId);
		
	}
}
