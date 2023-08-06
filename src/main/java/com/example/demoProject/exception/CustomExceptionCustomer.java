package com.example.demoProject.exception;

public class CustomExceptionCustomer extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomExceptionCustomer(String message) {
		super(message);
	}
}
