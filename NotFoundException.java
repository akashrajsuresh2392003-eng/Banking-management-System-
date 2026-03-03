package edu.jsp.BankingApplication.exception;

public class NotFoundException extends RuntimeException {

	String message;

	public NotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
