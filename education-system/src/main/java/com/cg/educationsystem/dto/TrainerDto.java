package com.cg.educationsystem.dto;


public class TrainerDto {
	private int trainerId;
	private String trainerName;
	private long phoneNumber;
	private int trainerExperience;
	private String trainerEmailId;
	private int studentId;
	private int courseId;
	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
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
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public TrainerDto(int trainerId, String trainerName, long phoneNumber, int trainerExperience, String trainerEmailId,
			int studentId, int courseId) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.phoneNumber = phoneNumber;
		this.trainerExperience = trainerExperience;
		this.trainerEmailId = trainerEmailId;
		this.studentId = studentId;
		this.courseId = courseId;
	}
	
	
}
