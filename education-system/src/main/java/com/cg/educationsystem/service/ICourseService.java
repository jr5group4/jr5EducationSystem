package com.cg.educationsystem.service;

import java.util.List;

import com.cg.educationsystem.dto.CourseDto;
import com.cg.educationsystem.entity.Course;

public interface ICourseService {
	//allows student/user to register a course
	public List<Course> registerCourse(int courseId,int studentId);
	//allows admin to add course details
	public List<Course> addCourseDetails(CourseDto course);
	//allows admin to delete course details
	public List<Course> deleteCourse(int courseId);
	//allows admin and student to view perticular course
	public Course getCourseById(int courseId);
	//allows admin and student to view all the courses
	public List<Course> getAllCourse();
	//allows admin to update course details
	public List<Course> updateCourse(CourseDto courseDto);
	
	public List<Course> getAllUpcommingCourses();
	
	public List<Course> getAllRegisteredCourse(int studentId);
	
	public List<Course> getAllOngoingCourses(int studentId);
	
	public List<Course> completedCourses(int studentId);
}
