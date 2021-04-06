package com.cg.educationsystem.entity;


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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="studentId")
	private StudentDetails student;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="courseId")
	private Course course;
	
	public Trainer() {
		
	}
	
	public Trainer(int trainerId, String trainerName, long phoneNumber, int trainerExperience, String trainerEmailId,
			StudentDetails student, Course course) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.phoneNumber = phoneNumber;
		this.trainerExperience = trainerExperience;
		this.trainerEmailId = trainerEmailId;
		this.student = student;
		this.course = course;
	}

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
