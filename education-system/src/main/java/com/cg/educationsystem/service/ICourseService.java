package com.cg.educationsystem.service;

import com.cg.educationsystem.dto.CourseDto;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.entity.StudentDetails;

public interface ICourseService {
	public String registerCourse(CourseDto courseDto);
	public void addCourseDetails(Course course);
}
