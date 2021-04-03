package com.cg.educationsystem.service;

import java.util.List;

import com.cg.educationsystem.dto.CourseDto;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.entity.StudentDetails;

public interface ICourseService {
	public String registerCourse(CourseDto courseDto);
	public void addCourseDetails(Course course);
	public void deleteCourse(int courseId);
	public Course getCourseById(int courseId);
	public List<Course> getAllCourse();
}
