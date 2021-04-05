package com.cg.educationsystem.entity;


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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="trainer")
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trainerId;
	
	@Column(length=30)
	private String trainerName;
	
	@Column(length=30)
	private long phoneNumber;
	
	@Column(length=30)
	private int trainerExperience;
	
	@Column(length=30)
	private String trainerEmailId;
	
	/*@ManyToOne
	@JoinColumn(name = "studentId")
	private StudentDetails studentdetails;*/
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="studentId")
	private StudentDetails student;
	
	/*@ManyToMany(targetEntity = Course.class, cascade = { CascadeType.ALL }) 
	@JoinTable(name = "trainer_course",   
    joinColumns = { @JoinColumn(name = "trainerId") },   
    inverseJoinColumns = { @JoinColumn(name = "courseId") })
	private List<Course> courseList;*/
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="courseId")
	private Course course;
	
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getTrainerExperience() {
		return trainerExperience;
	}
	public void setTrainerExperience(int trainerExperience) {
		this.trainerExperience = trainerExperience;
	}
	public String getTrainerEmailId() {
		return trainerEmailId;
	}
	public void setTrainerEmailId(String trainerEmailId) {
		this.trainerEmailId = trainerEmailId;
	}
	/*public StudentDetails getStudentdetails() {
		return studentdetails;
	}
	public void setStudentdetails(StudentDetails studentdetails) {
		this.studentdetails = studentdetails;
	}*/
	
	public StudentDetails getStudent() {
		return student;
	}
	public void setStudent(StudentDetails student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
}
