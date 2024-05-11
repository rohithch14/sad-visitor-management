package com.visitormanagement.exceptions;

public class MaximumPassRequestLimitReachedException extends RuntimeException {
   
	private static final long serialVersionUID = 1L;

	public MaximumPassRequestLimitReachedException(String message) {
        super(message);
    }
}