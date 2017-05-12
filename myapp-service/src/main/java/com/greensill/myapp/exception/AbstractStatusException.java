package com.greensill.myapp.exception;

public abstract class AbstractStatusException extends SampleException {

	private static final long serialVersionUID = 4032552937557533152L;

	public AbstractStatusException(String message, Throwable cause) {
		super(message, cause);
	}

	public AbstractStatusException(String message) {
		super(message);
	}

	public abstract Integer getStatus();

}
