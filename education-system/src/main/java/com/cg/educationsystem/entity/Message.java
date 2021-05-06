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
@Table(name = "message")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int messageId;
	
	@Column(length = 250)
	private String messageDescription;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="studentId")
	private StudentDetails studentDetails;
	
	public Message(int messageId, String messageDescription, StudentDetails studentDetails) {
		this.messageId = messageId;
		this.messageDescription = messageDescription;
		this.studentDetails = studentDetails;
	}
	
	public Message(int messageId, String messageDescription) {
		super();
		this.messageId = messageId;
		this.messageDescription = messageDescription;
	}

	public Message() {
		
	}
	
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getMessageDescription() {
		return messageDescription;
	}
	public void setMessageDescription(String messageDescription) {
		this.messageDescription = messageDescription;
	}
	public StudentDetails getStudentDetails() {
		return studentDetails;
	}
	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}
	
}
