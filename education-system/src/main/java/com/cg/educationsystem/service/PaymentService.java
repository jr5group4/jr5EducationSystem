package com.cg.educationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.educationsystem.dao.IPaymentRepository;
import com.cg.educationsystem.entity.Payment;

@Service
public class PaymentService implements IPaymentService{
	@Autowired
	IPaymentRepository dao;

	@Override
	public void addPayment(Payment payment) {
		dao.save(payment);
		
	}

	@Override
	public Payment getPaymentById(int paymentId) {
		return dao.getPaymentById(paymentId);
	}
}
