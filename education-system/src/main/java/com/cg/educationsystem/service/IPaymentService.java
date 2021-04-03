package com.cg.educationsystem.service;

import com.cg.educationsystem.dto.PaymentDto;
import com.cg.educationsystem.entity.Payment;

public interface IPaymentService {
	public void addPayment(PaymentDto paymentDto);
	public Payment getPaymentById(int paymentId);
}
