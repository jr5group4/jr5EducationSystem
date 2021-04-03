package com.cg.educationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.educationsystem.dao.ICourseRepository;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.entity.StudentDetails;

@Service
public class CourseService implements ICourseService {
	@Autowired
	ICourseRepository courseRepository;

	@Override
	public String registerCourse(Course course, StudentDetails student) {
		if(courseRepository.existsById(course.getCourseId())) {
			Course newCourse=courseRepository.findById(course.getCourseId()).get();
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
