package com.cg.educationsystem.utils;

public class InvalidUserIdOrPasswordException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidUserIdOrPasswordException(String message) {
		super(message);
	}
}
