package com.cjc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cjc.exception.EnquiryServiceException;
import com.cjc.model.EnquiryError;


@ControllerAdvice
public class ExceptionAdvice2 {
	@ExceptionHandler(EnquiryServiceException.class)
	public ResponseEntity<EnquiryError> mapStudentError(EnquiryServiceException se){
		
		System.out.println("3 in exceptionadvice");
		EnquiryError serror=new EnquiryError(HttpStatus.INTERNAL_SERVER_ERROR.value(),se.getMessage());
		
		return new ResponseEntity<EnquiryError>(serror ,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
