package com.cg.educationsystem.utils;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class StockExceptionController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ProgressReportNotFoundException.class)
	public ResponseEntity<ErrorDetails> reportNotFoundException(ProgressReportNotFoundException exception, WebRequest request) {
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TrainerNotFoundException.class)
	public ResponseEntity<ErrorDetails> trainerNotFound(TrainerNotFoundException exception,WebRequest request){
		ErrorDetails details = new ErrorDetails(exception.getMessage(), LocalDate.now(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	}
}
