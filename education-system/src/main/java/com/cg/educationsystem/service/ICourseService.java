package com.cg.educationsystem.service;

import java.util.List;

import com.cg.educationsystem.dto.CourseDto;
import com.cg.educationsystem.entity.Course;

public interface ICourseService {
	//allows student/user to register a course
	public int registerCourse(CourseDto courseDto);
	//allows admin to add course details
	public void addCourseDetails(Course course);
	//allows admin to delete course details
	public int deleteCourse(int courseId);
	//allows admin and student to view perticular course
	public Course getCourseById(int courseId);
	//allows admin and student to view all the courses
	public List<Course> getAllCourse();
	//allows admin to update course details
	public int updateCourse(CourseDto courseDto);
}
