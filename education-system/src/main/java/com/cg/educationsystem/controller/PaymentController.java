package com.cg.educationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.cg.educationsystem.utils.CourseNotFoundException;
import com.cg.educationsystem.utils.PaymentNotFoundException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	
	String string="No payment found for payment id: ";
	
	@PostMapping("/add")
	public ResponseEntity<List<Payment>> addPayment(@RequestBody PaymentDto paymentdto){
		List<Payment> payment=paymentService.addPayment(paymentdto);
		if(payment.isEmpty()) {
			throw new CourseNotFoundException("Course not available for Id: "+paymentdto.getCourseId());
		}
		return new ResponseEntity<>(payment, HttpStatus.OK);
	}
	@GetMapping("/getall")
	public ResponseEntity<List<Payment>> getAllPayment(){
		List<Payment> paymentList = paymentService.getAllPayment();
		if(paymentList.isEmpty()) {
			throw new PaymentNotFoundException("No payment available");
		}
		return new ResponseEntity<>(paymentList, HttpStatus.OK);
	}
	@GetMapping("/getbyid/{studentId}/{courseId}")
	public ResponseEntity<List<Payment>> getPaymentById(@PathVariable int studentId,@PathVariable int courseId){
		List<Payment> paymentList =paymentService.getPaymentById(studentId,courseId);
		/*if(payment==null) {
			throw new PaymentNotFoundException(string+studentId);
		}*/
		return new ResponseEntity<>(paymentList, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{paymentId}")
	public ResponseEntity<List<Payment>> deletePayment(@PathVariable("paymentId") int paymentId){
		List<Payment> payment=paymentService.deletePayment(paymentId);
		if(payment.isEmpty()) {
			throw new PaymentNotFoundException(string+paymentId);
		}
		return new ResponseEntity<>(payment, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<List<Payment>> updatePayment(@RequestBody PaymentDto paymentDto){
		List<Payment> payment=paymentService.updatePayment(paymentDto);
		if(payment.isEmpty()) {
			throw new PaymentNotFoundException(string+paymentDto.getPaymentId());
		}
		return new ResponseEntity<>(payment, HttpStatus.OK);
	}

}
