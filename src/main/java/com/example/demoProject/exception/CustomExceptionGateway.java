package com.example.demoProject.exception;

public class CustomExceptionGateway extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomExceptionGateway (String message) {
		super(message);
	}
}
