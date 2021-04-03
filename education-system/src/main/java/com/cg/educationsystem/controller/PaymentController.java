package com.cg.educationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.educationsystem.dto.PaymentDto;
import com.cg.educationsystem.entity.Payment;
import com.cg.educationsystem.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	
	@PostMapping
	public ResponseEntity<String> addPayment(@RequestBody PaymentDto payment){
		paymentService.addPayment(payment);
		return new ResponseEntity<String>("Payment inserted", HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<Payment>> getAllPayment(){
		List<Payment> paymentList = paymentService.getAllPayment();
		return new ResponseEntity<List<Payment>>(paymentList, HttpStatus.OK);
	}
/*	@GetMapping("/getpaymentbyid")
	public ResponseEntity<Payment> getPaymentById(@RequestBody int paymentId){
		Payment payment =paymentService.getPaymentById(paymentId);
		return new ResponseEntity<Payment>(, HttpStatus.OK);
	}*/

}
