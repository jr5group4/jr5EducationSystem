package com.cg.educationsystem.utils;

public class CourseNotFoundException extends RuntimeException {
	public CourseNotFoundException(String message) {
		super(message);
	}
}
