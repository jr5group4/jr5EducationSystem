package com.cg.educationsystem.dto;

import java.sql.Date;

public class CourseDto {
	private int courseId;
	private String courseName;
	private int duration;
	private Date startDate;
	private Date endDate;
	private int trainerId;
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
	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public CourseDto() {
		
	}
	public CourseDto(int courseId, String courseName, int duration, Date startDate, Date endDate) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.duration = duration;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public CourseDto(int courseId, String courseName, int duration, Date startDate, Date endDate, int studentId) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.duration = duration;
		this.startDate = startDate;
		this.endDate = endDate;
		this.studentId = studentId;
	}
	
	
}
