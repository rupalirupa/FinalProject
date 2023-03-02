package com.cjc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cjc.exception.CustomerServiceException;
import com.cjc.model.CustomerError;


@ControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler(CustomerServiceException.class)
	public ResponseEntity<CustomerError> mapStudentError(CustomerServiceException se){
		
		System.out.println("3 in exceptionadvice");
		CustomerError serror=new CustomerError(HttpStatus.INTERNAL_SERVER_ERROR.value(),se.getMessage());
		
		return new ResponseEntity<CustomerError>(serror ,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
