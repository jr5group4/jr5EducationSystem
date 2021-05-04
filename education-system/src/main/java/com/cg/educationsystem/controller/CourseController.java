package com.cg.educationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.educationsystem.dto.CourseDto;
import com.cg.educationsystem.dto.ProgressReportDto;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.service.CourseService;
import com.cg.educationsystem.utils.CourseNotFoundException;
import com.cg.educationsystem.utils.ProgressReportNotFoundException;

@RestController
@RequestMapping("/course")
public class CourseController {
	String string="No course found for course Id : ";
	
	@Autowired
	CourseService courseService;
	
	@PostMapping("/registercourse")
	public ResponseEntity<String> registerCourse(@RequestBody CourseDto courseDto){
		int number=courseService.registerCourse(courseDto);
		if(number==0) {
			throw new CourseNotFoundException(string+courseDto.getCourseId());
		}
		return new ResponseEntity<>("Course registered successfully",HttpStatus.OK);
	}
	
	@PostMapping("/addcourse")
	public ResponseEntity<String> addCourseDetails(@RequestBody Course course){
		courseService.addCourseDetails(course);
		return new ResponseEntity<>("Course added",HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecourse/{courseId}")
	public ResponseEntity<String> deleteCourse(@PathVariable int courseId){
		int number=courseService.deleteCourse(courseId);
		if(number==0) {
			throw new CourseNotFoundException(string+courseId);
		}
		return new ResponseEntity<>("Course deleted",HttpStatus.OK);
	}
	
	@GetMapping("/getallcourses")
	public ResponseEntity<List<Course>> getAllCourse(){
		List<Course> courseList=courseService.getAllCourse();
		if(courseList.isEmpty()) {
			throw new CourseNotFoundException("No course available ");
		}
		return new ResponseEntity<>(courseList,HttpStatus.OK);
	}
	
	@GetMapping("/getcoursebyid/{courseId}")
	public ResponseEntity<Course> getCourseById(@PathVariable int courseId){
		Course course=courseService.getCourseById(courseId);
		if(course==null) {
			throw new CourseNotFoundException(string+courseId);
		}
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
	
	@PutMapping("/updatecourse")
	public ResponseEntity<String> updateCourse(@RequestBody CourseDto courseDto){
		int number=courseService.updateCourse(courseDto);
		if(number==0) {
			throw new CourseNotFoundException("No Course Found for Course Id : "+courseDto.getCourseId());
		}
		return new ResponseEntity<>("Course Updated",HttpStatus.OK);
	}
}
