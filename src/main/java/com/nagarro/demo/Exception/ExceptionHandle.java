package com.nagarro.demo.Exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.function.EntityResponse;

@ControllerAdvice
public class ExceptionHandle {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	  public final ResponseEntity<ExceptionResponse> handleResourceNotFoundException
	            (ResourceNotFoundException ex) 
	  {
		ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("Record not found");
        response.setErrorMessage(ex.getMessage());
		return new ResponseEntity(response,HttpStatus.NOT_FOUND);
	  }
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	  public final ResponseEntity<ExceptionResponse> handleMethodMismatchException
	            (MethodArgumentTypeMismatchException ex) 
	  {
		ExceptionResponse response = new ExceptionResponse();
      response.setErrorCode("Request parameters InValid ");
      response.setErrorMessage(ex.getMessage());
		return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
	  }
	
	@ExceptionHandler(RuntimeException.class)
	  public final ResponseEntity<ExceptionResponse> handleMethodMismatchException
	            (RuntimeException ex) 
	  {
		ExceptionResponse response = new ExceptionResponse();
    response.setErrorCode("Internal Application Error");
    response.setErrorMessage(ex.getMessage());
		return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	
	@ExceptionHandler(Unauthorized.class)
	  public final ResponseEntity<ExceptionResponse> handleMethodMismatchException
	            (Unauthorized ex) 
	  {
		ExceptionResponse response = new ExceptionResponse();
  response.setErrorCode("Unauthorized User");
  response.setErrorMessage(ex.getMessage());
		return new ResponseEntity(response,HttpStatus.UNAUTHORIZED);
	  }
}
