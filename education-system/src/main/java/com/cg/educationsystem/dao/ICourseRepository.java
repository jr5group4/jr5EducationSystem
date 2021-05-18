package com.cg.educationsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.educationsystem.entity.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer> {
	@Query(value = "from Course course where course.courseId=?1")
	public Course getCourseById(int courseId);
	@Query(value="from Course course where course.startDate>current_date and course.student=null")
	public List<Course> getAllUpcommingCourses();
	@Query(value="from Course course where course.startDate>current_date and course.student.studentId=?1")
	public List<Course> getAllRegisteredCourses(int studentId);
	@Query(value="from Course course where course.endDate>current_date and course.student.studentId=?1")
	public List<Course> getAllOngoingCourses(int studentId);  
	@Query(value="from Course course where course.endDate<current_date and course.student.studentId=?1")
	public List<Course> completedCourses(int studentId);
}
