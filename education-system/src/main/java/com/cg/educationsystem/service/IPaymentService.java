package com.cg.educationsystem.service;

import com.cg.educationsystem.entity.Payment;

public interface IPaymentService {
	public void addPayment(Payment payment);
	public Payment getPaymentById(int paymentId);
}
