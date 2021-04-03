package com.cg.educationsystem.dto;

import java.util.List;

public class TrainerDto {
	private int trainerId;
	private String trainerName;
	private long phoneNumber;
	private int trainerExperience;
	private String trainerEmailId;
	private int studentId;
	private List<Integer> courseIdList;
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
	public List<Integer> getCourseIdList() {
		return courseIdList;
	}
	public void setCourseIdList(List<Integer> courseIdList) {
		this.courseIdList = courseIdList;
	}
	
}
