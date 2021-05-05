package com.cg.educationsystem.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	
	@Column(length=30)
	private String courseName;
	
	@Column(length=30)
	private int duration;
	
	@Column
	private Date startDate;
	
	@Column
	private Date endDate;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="studentId")
	private StudentDetails student;
	
	public Course() {
		
	}
	
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
	public StudentDetails getStudent() {
		return student;
	}
	public void setStudent(StudentDetails student) {
		this.student = student;
	}
	

	public Course(int courseId, String courseName, int duration, Date startDate, Date endDate, StudentDetails student) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.duration = duration;
		this.startDate = startDate;
		this.endDate = endDate;
		this.student = student;
	}
	
}
