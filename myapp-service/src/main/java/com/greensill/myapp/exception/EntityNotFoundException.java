package com.greensill.myapp.exception;

public class EntityNotFoundException extends AbstractStatusException {

	private static final long serialVersionUID = 5887077776108220743L;

	private static final Integer STATUS = 404;

	public EntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityNotFoundException(String message) {
		super(message);
	}

	@Override
	public Integer getStatus() {
		return STATUS;
	}

}
