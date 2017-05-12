package com.greensill.myapp.exception;

public class SampleException extends RuntimeException {

	private static final long serialVersionUID = -3059800491799980568L;

	public SampleException(String message, Throwable cause) {
		super(message, cause);
	}

	public SampleException(String message) {
		super(message);
	}

}
