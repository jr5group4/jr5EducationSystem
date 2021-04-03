package com.cg.educationsystem.service;

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
	IStudentDetailsRepository studentDetailsRepository;
	
	@Override
	public String registerCourse(CourseDto courseDto, StudentDetails student) {
		if(courseRepository.existsById(courseDto.getCourseId())) {
			CourseDto newCourse=courseRepository.findById(courseDto.getCourseId()).get();
			newCourse.setStudentdetails(student);
			courseRepository.save(newCourse);
		}
		return null;
	}

	@Override
	public void addCourseDetails(Course course) {
		// TODO Auto-generated method stub
		courseRepository.save(course);
	}
}
