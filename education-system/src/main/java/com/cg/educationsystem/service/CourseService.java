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
	public String registerCourse(CourseDto courseDto) {
		if(courseRepository.existsById(courseDto.getCourseId())) {
			Course course=courseRepository.findById(courseDto.getCourseId()).get();
			StudentDetails student=studentDetailsRepository.findById(courseDto.getStudentId()).get();
			course.setStudentdetails(student);
			courseRepository.save(course);
		}
		return null;
	}

	@Override
	public void addCourseDetails(Course course) {
		courseRepository.save(course);
	}
}
