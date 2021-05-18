package com.cg.educationsystem.service;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.educationsystem.dao.ICourseRepository;
import com.cg.educationsystem.dao.IStudentDetailsRepository;
import com.cg.educationsystem.dao.ITrainerRepository;
import com.cg.educationsystem.dto.CourseDto;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.entity.StudentDetails;
import com.cg.educationsystem.entity.Trainer;

@Service
public class CourseService implements ICourseService {
	@Autowired
	ICourseRepository courseRepository;
	@Autowired
	IStudentDetailsRepository studentDetailsRepository;
	@Autowired
	ITrainerRepository trainerRepository;
	
	@Override
	public List<Course> registerCourse(int courseId,int studentId) {
		Course course=courseRepository.getCourseById(courseId);
		StudentDetails student=studentDetailsRepository.getStudentDetailsById(studentId);
		if(course!=null&&student!=null) {
			course.setStudent(student);
			courseRepository.save(course);
			return courseRepository.findAll();
		}
		return Collections.emptyList();
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
			course.setStudent(null);
			courseRepository.save(course);
			courseRepository.deleteById(courseId);
			return courseRepository.findAll();
		}
		return Collections.emptyList();
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
			courseRepository.save(course);
			return courseRepository.findAll();
		}
		return Collections.emptyList();
	}

	@Override
	public List<Course> getAllUpcommingCourses() {
		return courseRepository.getAllUpcommingCourses();
	}

	@Override
	public List<Course> getAllRegisteredCourse(int studentId) {
		List<Course> courseList= courseRepository.getAllRegisteredCourses(studentId);
		Course newCourse=null;
		for(Course course:courseList) {
			List<Trainer> trainerList=trainerRepository.getTrainerByCourse(course.getCourseId());
			if(trainerList.isEmpty()) {
				newCourse=course;
			}
		}
		courseList.remove(newCourse);
		return courseList;
	}

	@Override
	public List<Course> getAllOngoingCourses(int studentId) {
		List<Course> courseList= courseRepository.getAllOngoingCourses(studentId);
		Course newCourse=null;
		for(Course course:courseList) {
			List<Trainer> trainerList=trainerRepository.getTrainerByCourse(course.getCourseId());
			if(!trainerList.isEmpty()) {
				newCourse=course;
			}
		}
		courseList.remove(newCourse);
		return courseList;
	}

	@Override
	public List<Course> completedCourses(int studentId) {
		return courseRepository.completedCourses(studentId);
	}
}
