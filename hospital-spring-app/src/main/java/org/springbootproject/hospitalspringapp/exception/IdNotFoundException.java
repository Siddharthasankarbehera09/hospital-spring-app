package org.springbootproject.hospitalspringapp.exception;

public class IdNotFoundException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Id Not Found or Invalid Id";
	}
}
