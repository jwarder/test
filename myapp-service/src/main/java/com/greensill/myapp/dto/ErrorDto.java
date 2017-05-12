package com.greensill.myapp.dto;

public class ErrorDto {

	protected String errorMessage;

	protected int status;

	public ErrorDto(String errorMessage, int status) {
		super();
		this.errorMessage = errorMessage;
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public int getStatus() {
		return status;
	}

}
