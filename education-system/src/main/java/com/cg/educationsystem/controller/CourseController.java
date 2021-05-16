package com.cg.educationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.educationsystem.dto.CourseDto;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.service.CourseService;
import com.cg.educationsystem.utils.CourseNotFoundException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/course")
public class CourseController {
	String string="No course found for course Id : ";
	
	@Autowired
	CourseService courseService;
	
	@PutMapping("/register/{courseId}/{studentId}")
	public ResponseEntity<List<Course>> registerCourse(@PathVariable int courseId,@PathVariable int  studentId){
		List<Course> course=courseService.registerCourse(courseId,studentId);
		if(course.isEmpty()) {
			throw new CourseNotFoundException(string+courseId);
		}
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<List<Course>> addCourseDetails(@RequestBody Course courseNew){
		List<Course> course=courseService.addCourseDetails(courseNew);
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{courseId}")
	public ResponseEntity<List<Course>> deleteCourse(@PathVariable("courseId") int courseId){
		List<Course> course=courseService.deleteCourse(courseId);
		if(course.isEmpty()) {
			throw new CourseNotFoundException(string+courseId);
		}
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Course>> getAllCourse(){
		List<Course> courseList=courseService.getAllCourse();
		if(courseList.isEmpty()) {
			throw new CourseNotFoundException("No course available ");
		}
		return new ResponseEntity<>(courseList,HttpStatus.OK);
	}
	@GetMapping("/getallupcomming")
	public ResponseEntity<List<Course>> getAllUpcommingCourses(){
		List<Course> courseList=courseService.getAllUpcommingCourses();
		if(courseList.isEmpty()) {
			throw new CourseNotFoundException("No course available ");
		}
		return new ResponseEntity<>(courseList,HttpStatus.OK);
	}
	
	@GetMapping("/getallregistered/{studentId}")
	public ResponseEntity<List<Course>> getAllRegisteredCourses(@PathVariable int studentId){
		List<Course> courseList=courseService.getAllRegisteredCourse(studentId);
		if(courseList.isEmpty()) {
			throw new CourseNotFoundException("No course available ");
		}
		return new ResponseEntity<>(courseList,HttpStatus.OK);
	}
	
	@GetMapping("/getbyid/{courseId}")
	public ResponseEntity<Course> getCourseById(@PathVariable("courseId") int courseId){
		Course course=courseService.getCourseById(courseId);
		if(course==null) {
			throw new CourseNotFoundException(string+courseId);
		}
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<List<Course>> updateCourse(@RequestBody CourseDto courseDto){
		List<Course> course=courseService.updateCourse(courseDto);
		if(course.isEmpty()) {
			throw new CourseNotFoundException("No Course Found for Course Id : "+courseDto.getCourseId());
		}
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
}
