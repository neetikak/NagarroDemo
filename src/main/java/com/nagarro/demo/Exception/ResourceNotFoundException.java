package com.nagarro.demo.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

 
public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
