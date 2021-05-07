package com.cg.educationsystem.dto;

public class MessageDto {
	private int messageId;
	private String messageDescription;
	private int studentId;
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
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public MessageDto() {
		
	}
	
	public MessageDto(int messageId, String messageDescription) {
		super();
		this.messageId = messageId;
		this.messageDescription = messageDescription;
	}
	public MessageDto(int messageId, String messageDescription, int studentId) {
		super();
		this.messageId = messageId;
		this.messageDescription = messageDescription;
		this.studentId = studentId;
	}
	
}
