package com.codinsaint.tutorial.spring.userservice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler
	public ResponseEntity<ApplicationErrors>handleUserNotFoundException(UserNotFoundException ex, WebRequest webRequest){
		ApplicationErrors errors= new ApplicationErrors(ex.getMessage(), "404");
		errors.setDate(new Date());
		return new ResponseEntity<ApplicationErrors>(errors, HttpStatus.NOT_FOUND);
		
	}

}
