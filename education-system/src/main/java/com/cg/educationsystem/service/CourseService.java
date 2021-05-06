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
	public List<Course> registerCourse(CourseDto courseDto) {
		Course course=courseRepository.getCourseById(courseDto.getCourseId());
		StudentDetails student=studentDetailsRepository.getStudentDetailsById(courseDto.getStudentId());
		if(course!=null&&student!=null) {
			course.setStudent(student);
			courseRepository.save(course);
			return courseRepository.findAll();
		}
		return null;
	}

	@Override
	public List<Course> addCourseDetails(Course course) {
		courseRepository.save(course);
		return courseRepository.findAll();
	}

	@Override
	public List<Course> deleteCourse(int courseId) {
		Course course=courseRepository.getCourseById(courseId);
		if(course!=null) {
			courseRepository.delete(course);
			return courseRepository.findAll();
		}
		return null;
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
	public List<Course> updateCourse(CourseDto courseDto) {
		Course course=courseRepository.getCourseById(courseDto.getCourseId());
		StudentDetails studentDetails=studentDetailsRepository.getStudentDetailsById(courseDto.getStudentId());
		if(course!=null&&studentDetails!=null) {
			course.setCourseName(courseDto.getCourseName());
			course.setDuration(courseDto.getDuration());
			course.setStartDate(courseDto.getStartDate());
			course.setEndDate(courseDto.getEndDate());
			course.setStudent(studentDetails);
			return courseRepository.findAll();
		}
		return null;
	}
}
