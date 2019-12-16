package com.mobiliya.expensemanager.exception.handler;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mobiliya.expensemanager.dto.ApiErrorDto;
import com.mobiliya.expensemanager.exception.DataRetrievalException;
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex,WebRequest request) {
		ApiErrorDto apiErrorDto=new ApiErrorDto(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
		return new ResponseEntity<>(apiErrorDto,apiErrorDto.getStatus());
	}
	@ExceptionHandler(DataRetrievalException.class)
	protected ResponseEntity<Object> handleDaoException(DataRetrievalException ex,WebRequest request) {
		ApiErrorDto apiErrorDto=new ApiErrorDto(HttpStatus.BAD_REQUEST);
		apiErrorDto.setMessage("Exception Occured while Retrieving Data");
		return new ResponseEntity<>(apiErrorDto,apiErrorDto.getStatus());
	}

}
