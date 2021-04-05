package com.cg.educationsystem.dto;

import java.sql.Date;
import java.util.List;

import com.cg.educationsystem.entity.StudentDetails;

public class CourseDto {
	/*private List<Integer> courseIdList;
	private int studentId;
	public List<Integer> getCourseIdList() {
		return courseIdList;
	}
	public void setCourseIdList(List<Integer> courseIdList) {
		this.courseIdList = courseIdList;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}*/
	
	
	private int courseId;
	private String courseName;
	private int duration;
	private Date startDate;
	private Date endDate;
	private int studentId;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
}
