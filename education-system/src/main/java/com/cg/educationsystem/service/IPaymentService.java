package com.cg.educationsystem.service;

import java.util.List;

import com.cg.educationsystem.dto.PaymentDto;
import com.cg.educationsystem.entity.Payment;
public interface IPaymentService {
	//allows admin to add payment details of a student based on course
	public List<Payment> addPayment(PaymentDto paymentDto);
	//allows student/user to view payment details
	public Payment getPaymentById(int paymentId);
	//allows admin to view all payment details
	public List<Payment> getAllPayment();
	
	public List<Payment> deletePayment(int paymentId);
	
	public List<Payment> updatePayment(PaymentDto paymentDto);
}
