package com.example.Employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(SalaryNotFoundException.class)
	public ResponseEntity<Object>SalaryHandle(SalaryNotFoundException s1) {
		return new ResponseEntity<>(s1.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<Object>NameHandle(NameNotFoundException a) {
		return new ResponseEntity<>(a.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	}


