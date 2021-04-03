package com.cg.educationsystem.service;

import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.entity.StudentDetails;

public interface ICourseService {
	public String registerCourse(Course course,StudentDetails student);
	public void addCourseDetails(Course course);
}
