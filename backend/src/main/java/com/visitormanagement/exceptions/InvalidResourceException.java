// Defines a package in which the classes are
package com.visitormanagement.exceptions;

// Importing the necessary class from the Spring framework
import org.springframework.web.bind.annotation.ResponseStatus;

// @ResponseStatus annotation is a marker for any exceptions that you would like to catch and return a specific HTTP status code.
@ResponseStatus
public class InvalidResourceException extends RuntimeException{
	
	// serialVersionUID is used for version control for any Serializable class. If your class definition changes, you change this version number, so the JVM can know if the serialized object version matches the current class version.
	private static final long serialVersionUID = 1L;

	// Constructor that accepts a message
	public InvalidResourceException(String message) {
		// Calls the parent constructor with the message
		super(message);
	}
} 
