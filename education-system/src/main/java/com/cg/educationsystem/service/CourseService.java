package com.cg.educationsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.educationsystem.dao.ICourseRepository;
import com.cg.educationsystem.dao.IStudentDetailsRepository;
import com.cg.educationsystem.dto.CourseDto;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.entity.ProgressReport;
import com.cg.educationsystem.entity.StudentDetails;

@Service
public class CourseService implements ICourseService {
	@Autowired
	ICourseRepository courseRepository;
	@Autowired
	IStudentDetailsRepository studentDetailsRepository;
	
	@Override
	public int registerCourse(CourseDto courseDto) {
		Course course=courseRepository.getCourseById(courseDto.getCourseId());
		StudentDetails student=studentDetailsRepository.getStudentDetailsById(courseDto.getStudentId());
		if(course!=null&&student!=null) {
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
		Optional<Course> courseOptional=courseRepository.findById(courseId);
		if(courseOptional.isPresent()) {
			Course course=courseOptional.get();
			courseRepository.delete(course);
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

	@Override
	public int updateCourse(CourseDto courseDto) {
		Course course=courseRepository.getCourseById(courseDto.getCourseId());
		StudentDetails studentDetails=studentDetailsRepository.getStudentDetailsById(courseDto.getCourseId());
		if(course!=null) {
			course.setCourseName(courseDto.getCourseName());
			course.setDuration(courseDto.getDuration());
			course.setStartDate(courseDto.getStartDate());
			course.setEndDate(courseDto.getEndDate());
			course.setStudent(studentDetails);
			return 1;
		}
		return 0;
	}
}
