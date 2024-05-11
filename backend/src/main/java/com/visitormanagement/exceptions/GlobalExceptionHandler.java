// Defines a package in which the classes are
package com.visitormanagement.exceptions;

// Importing the necessary classes from the Spring framework
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

// @RestController annotation is used to define the RESTful web services. It serves JSON, XML and custom response.
@RestController

// @ControllerAdvice is an annotation provided by Spring allowing you to write global code that can be applied to a wide range of controllers — varying from all controllers to a chosen package or even a specific annotation.
@ControllerAdvice
public class GlobalExceptionHandler {
	
	// @ExceptionHandler annotation is used to define the class of exception it will catch. You can define exception handlers as much as you want and it will catch exceptions thrown by the controller methods.
	@ExceptionHandler(InvalidResourceException.class)
	public ResponseEntity<?> handleInvalidResourceException(InvalidResourceException ex){
		// Creating a new instance of ErrorDetails with the status code and message from the exception
		ErrorDetails error=new ErrorDetails(409,ex.getMessage());
		// Returning a ResponseEntity with the ErrorDetails instance and the HTTP status
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
}
