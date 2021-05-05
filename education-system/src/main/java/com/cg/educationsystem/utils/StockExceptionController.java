package com.cg.educationsystem.utils;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class StockExceptionController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ProgressReportNotFoundException.class)
	public ResponseEntity<ErrorDetails> reportNotFoundException(ProgressReportNotFoundException exception, WebRequest request) {
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TrainerNotFoundException.class)
	public ResponseEntity<ErrorDetails> trainerNotFound(TrainerNotFoundException exception,WebRequest request){
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<ErrorDetails> courseNotFoundException(CourseNotFoundException exception, WebRequest request) {
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StudentDetailsNotFoundException.class)
	public ResponseEntity<ErrorDetails> studentDetailsNotFound(StudentDetailsNotFoundException exception,WebRequest request){
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MessageNotFoundException.class)
	public ResponseEntity<ErrorDetails> messageNotFound(MessageNotFoundException exception,WebRequest request){
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(PaymentNotFoundException.class)
	public ResponseEntity<ErrorDetails> paymentNotFound(PaymentNotFoundException exception,WebRequest request){
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
 	}
	@ExceptionHandler(InvalidUserIdOrPasswordException.class)
	public ResponseEntity<ErrorDetails> invalidUserIdOrPassword(InvalidUserIdOrPasswordException exception,WebRequest request){
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}
}
