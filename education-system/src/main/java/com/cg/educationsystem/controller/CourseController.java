package com.cg.educationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.educationsystem.dto.CourseDto;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.service.CourseService;
import com.cg.educationsystem.utils.CourseNotFoundException;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseService courseService;
	
	@PostMapping("/registercourse")
	public ResponseEntity<String> registerCourse(@RequestBody CourseDto courseDto){
		String string=courseService.registerCourse(courseDto);
		return new ResponseEntity<String>(string,HttpStatus.OK);
	}
	
	@PostMapping("/addcourse")
	public ResponseEntity<String> addCourseDetails(@RequestBody Course course){
		courseService.addCourseDetails(course);
		return new ResponseEntity<String>("Course added",HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecourse/{courseId}")
	public ResponseEntity<String> deleteCourse(@PathVariable int courseId){
		courseService.deleteCourse(courseId);
		return new ResponseEntity<String>("Course deleted",HttpStatus.OK);
	}
	
	@GetMapping("/getallcourses")
	public ResponseEntity<List<Course>> getAllCourse(){
		List<Course> courseList=courseService.getAllCourse();
		return new ResponseEntity<List<Course>>(courseList,HttpStatus.OK);
	}
	
	@GetMapping("/getcoursebyid/{courseId}")
	public ResponseEntity<Course> getCourseById(@PathVariable int courseId){
		Course course=courseService.getCourseById(courseId);
		if(course==null) {
			throw new CourseNotFoundException("No course found for course Id : "+courseId);
		}
		return new ResponseEntity<Course>(course,HttpStatus.OK);
	}
}
