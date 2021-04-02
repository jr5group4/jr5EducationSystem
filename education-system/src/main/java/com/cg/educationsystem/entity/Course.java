package com.cg.educationsystem.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name = "studentId")
	private StudentDetails studentdetails;
	
	@ManyToMany(targetEntity = Trainer.class, cascade = { CascadeType.ALL }) 
	@JoinTable(name = "course_trainer",   
    joinColumns = { @JoinColumn(name = "courseId") },   
    inverseJoinColumns = { @JoinColumn(name = "trainerId") })
	private List<Trainer> trainer;
	
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
	public StudentDetails getStudentdetails() {
		return studentdetails;
	}
	public void setStudentdetails(StudentDetails studentdetails) {
		this.studentdetails = studentdetails;
	}
	public List<Trainer> getTrainer() {
		return trainer;
	}
	public void setTrainer(List<Trainer> trainer) {
		this.trainer = trainer;
	}

}
