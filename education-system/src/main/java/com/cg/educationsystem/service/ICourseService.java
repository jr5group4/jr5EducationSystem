package com.cg.educationsystem.service;

import java.util.List;

import com.cg.educationsystem.dto.CourseDto;
import com.cg.educationsystem.entity.Course;

public interface ICourseService {
	public int registerCourse(CourseDto courseDto);
	public void addCourseDetails(Course course);
	public int deleteCourse(int courseId);
	public Course getCourseById(int courseId);
	public List<Course> getAllCourse();
}
