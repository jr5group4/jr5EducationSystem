package com.cg.educationsystem.utils;

public class PaymentNotFoundException extends RuntimeException{
	public PaymentNotFoundException(String message) {
		super(message);
	}
}
