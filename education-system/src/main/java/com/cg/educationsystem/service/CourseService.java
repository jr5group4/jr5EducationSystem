package com.cg.educationsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.educationsystem.dao.ICourseRepository;
import com.cg.educationsystem.dao.IStudentDetailsRepository;
import com.cg.educationsystem.dto.CourseDto;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.entity.StudentDetails;

@Service
public class CourseService implements ICourseService {
	@Autowired
	ICourseRepository courseRepository;
	@Autowired
	IStudentDetailsRepository studentDetailsRepository;
	
	@Override
	public int registerCourse(CourseDto courseDto) {
		if(courseRepository.existsById(courseDto.getCourseId())) {
			Course course=courseRepository.findById(courseDto.getCourseId()).get();
			StudentDetails student=studentDetailsRepository.findById(courseDto.getStudentId()).get();
			course.setStudent(student);
			courseRepository.save(course);
			return 1;
		}
		return 0;
	}

	@Override
	public void addCourseDetails(Course course) {
		courseRepository.save(course);
	}

	@Override
	public int deleteCourse(int courseId) {
		if(courseRepository.existsById(courseId)) {
			courseRepository.delete(courseRepository.findById(courseId).get());
			return 1;
		}
		return 0;
	}

	@Override
	public List<Course> getAllCourse() {
		return courseRepository.findAll();
	}

	@Override
	public Course getCourseById(int courseId) {
		return courseRepository.getCourseById(courseId);
	}
}
