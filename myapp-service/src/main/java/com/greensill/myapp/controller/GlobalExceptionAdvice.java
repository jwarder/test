package com.greensill.myapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.greensill.myapp.dto.ErrorDto;
import com.greensill.myapp.exception.AbstractStatusException;

@ControllerAdvice(basePackages = "com.greensill.myapp.controller")
public class GlobalExceptionAdvice {

	@ExceptionHandler(AbstractStatusException.class)
	public ResponseEntity<ErrorDto> handleStatusException(AbstractStatusException e) {
		ErrorDto error = new ErrorDto(e.getMessage(), e.getStatus());
		return new ResponseEntity<ErrorDto>(error, HttpStatus.valueOf(error.getStatus()));
	}

}
