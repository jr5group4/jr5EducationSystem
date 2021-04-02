package com.cg.educationsystem.service;

import com.cg.educationsystem.entity.Course;

public interface ICourseService {
	public String registerCourse(int courseId);
	public String addCourseDetails(Course course);
}
