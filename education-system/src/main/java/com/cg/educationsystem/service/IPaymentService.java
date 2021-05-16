package com.cg.educationsystem.service;

import java.util.List;

import com.cg.educationsystem.dto.PaymentDto;
import com.cg.educationsystem.entity.Payment;
public interface IPaymentService {
	//allows user to add payment details of a student based on course
	public List<Payment> addPayment(PaymentDto paymentDto);
	//allows student/user to view payment details
	public Payment getPaymentById(int studentId);
	//allows user to view all payment details
	public List<Payment> getAllPayment();
	//allows user to delete payment details
	public List<Payment> deletePayment(int paymentId);
	//allows user to update payment details
	public List<Payment> updatePayment(PaymentDto paymentDto);
}
