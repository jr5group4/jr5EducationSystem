package com.cg.educationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.educationsystem.dto.PaymentDto;
import com.cg.educationsystem.entity.Payment;
import com.cg.educationsystem.service.PaymentService;
import com.cg.educationsystem.utils.PaymentNotFoundException;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/addpayment")
	public ResponseEntity<String> addPayment(@RequestBody PaymentDto paymentdto){
		paymentService.addPayment(paymentdto);
		return new ResponseEntity<>("Payment inserted", HttpStatus.OK);
	}
	@GetMapping("/getallpayments")
	public ResponseEntity<List<Payment>> getAllPayment(){
		List<Payment> paymentList = paymentService.getAllPayment();
		if(paymentList.isEmpty()) {
			throw new PaymentNotFoundException("No payment available");
		}
		return new ResponseEntity<>(paymentList, HttpStatus.OK);
	}
	@GetMapping("/getpaymentbyid/{paymentId}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable int paymentId){
		Payment payment =paymentService.getPaymentById(paymentId);
		if(payment==null) {
			throw new PaymentNotFoundException("No payment found for payment id: "+paymentId);
		}
		return new ResponseEntity<>(payment, HttpStatus.OK);
	}
	
	@DeleteMapping("/deletepayment/{paymentId}")
	public ResponseEntity<String> deletePayment(@PathVariable int paymentId){
		int number=paymentService.deletePayment(paymentId);
		if(number==0) {
			throw new PaymentNotFoundException("No payment found for payment id: "+paymentId);
		}
		return new ResponseEntity<>("Payment Deleted", HttpStatus.OK);
	}
	
	@PutMapping("/updatepayment")
	public ResponseEntity<String> updatePayment(@RequestBody PaymentDto paymentDto){
		int number=paymentService.updatePayment(paymentDto);
		if(number==0) {
			throw new PaymentNotFoundException("No payment found for payment id: "+paymentDto.getPaymentId());
		}
		return new ResponseEntity<>("Payment Updated", HttpStatus.OK);
	}

}
